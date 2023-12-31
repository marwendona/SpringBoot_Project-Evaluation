package tn.primatec.evaluation.service.implement;

import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.primatec.evaluation.adapter.*;
import tn.primatec.evaluation.dao.*;
import tn.primatec.evaluation.dto.*;
import tn.primatec.evaluation.model.employee.EmployeeDetails;
import tn.primatec.evaluation.model.employee.EmployeeSummary;
import tn.primatec.evaluation.model.eval.*;
import tn.primatec.evaluation.service.EvalService;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EvalServiceImpl implements EvalService {
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EvalServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void loadFromExcel(String filePath) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        // Skip the header if there is one
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            EmployeeDto employeeDto = loadEmployee(row);

            SatisfactionDto satisfactionDto = loadSatisfaction(row);
            employeeDto.setSatisfaction(satisfactionDto);
            satisfactionDto.setEmployee(employeeDto);

            StabilityDto stabilityDto = loadStability(row);
            employeeDto.setStability(stabilityDto);
            stabilityDto.setEmployee(employeeDto);

            TechnicalEvaluationDto technicalEvaluationDto = loadTechnicalEvaluation(row);
            employeeDto.setTechnicalEvaluation(technicalEvaluationDto);
            technicalEvaluationDto.setEmployee(employeeDto);

            ObjectivesAndProactivityDto objectivesAndProactivityDto = loadObjectivesAndProactivity(row);
            employeeDto.setObjectivesAndProactivity(objectivesAndProactivityDto);
            objectivesAndProactivityDto.setEmployee(employeeDto);

            CareerAndTrainingsDto careerAndTrainingsDto = loadCareerAndTrainings(row);
            employeeDto.setCareerAndTrainings(careerAndTrainingsDto);
            careerAndTrainingsDto.setEmployee(employeeDto);

            YearlyEvaluationDto yearlyEvaluationDto = loadYearlyEvaluation(row);
            employeeDto.setYearlyEvaluation(yearlyEvaluationDto);
            yearlyEvaluationDto.setEmployee(employeeDto);

            employeeRepository.save(employeeDto);
        }

        fileInputStream.close();
    }

    private EmployeeDto loadEmployee(Row row) throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        Cell departmentCell = row.getCell(0);
        Cell teamCell = row.getCell(1);
        Cell nameAndSurnameCell = row.getCell(2);
        Cell jobTitleCell = row.getCell(3);
        Cell employmentDateCell = row.getCell(4);
        Cell employmentTypeCell = row.getCell(5);
        Cell gradeCell = row.getCell(6);
        Cell lastEvaluationScoreCell = row.getCell(7);
        Cell currentEvaluationScoreCell = row.getCell(8);
        Cell reviewDateCell = row.getCell(9);
        Cell reviewerCell = row.getCell(10);

        if (departmentCell != null) {
            employeeDto.setDepartment(departmentCell.getStringCellValue());
        }
        if (teamCell != null) {
            employeeDto.setTeam(teamCell.getStringCellValue());
        }
        if (nameAndSurnameCell != null) {
            employeeDto.setNameAndSurname(nameAndSurnameCell.getStringCellValue());
        }
        if (jobTitleCell != null) {
            employeeDto.setJobTitle(jobTitleCell.getStringCellValue());
        }
        if (employmentDateCell != null) {
            employeeDto.setEmploymentDate(dateFormat.parse(employmentDateCell.getStringCellValue()));
        }
        if (employmentTypeCell != null) {
            employeeDto.setEmploymentType(employmentTypeCell.getStringCellValue());
        }
        if (gradeCell != null) {
            employeeDto.setGrade(gradeCell.getStringCellValue());
        }
        if (lastEvaluationScoreCell != null) {
            employeeDto.setLastEvaluationScore(lastEvaluationScoreCell.getNumericCellValue());
        }
        if (currentEvaluationScoreCell != null) {
            employeeDto.setCurrentEvaluationScore(currentEvaluationScoreCell.getNumericCellValue());
        }
        if (reviewDateCell != null) {
            employeeDto.setReviewDate(dateFormat.parse(reviewDateCell.getStringCellValue()));
        }
        if (reviewerCell != null) {
            employeeDto.setReviewer(reviewerCell.getStringCellValue());
        }

        return employeeDto;
    }

    private SatisfactionDto loadSatisfaction(Row row) {
        Satisfaction satisfaction = new Satisfaction();

        Cell teamAtmosphereCell = row.getCell(25);
        Cell workloadCell = row.getCell(26);
        Cell compagnySatisfactionScaleCell = row.getCell(28);
        Cell satisfactionWithTechnicalLeaderCell = row.getCell(29);
        Cell satisfactionWithTeamLeaderCell = row.getCell(30);
        Cell satisfactionWithProjectCell = row.getCell(32);
        Cell satisfactionWithGroupLeaderCell = row.getCell(33);
        Cell satisfactionWithTeamBuildingCell = row.getCell(34);
        Cell satisfactionWithCareerPathCell = row.getCell(35);
        Cell didTheCompagnySatisfyYourAmbitionsCell = row.getCell(36);

        if (teamAtmosphereCell != null) {
            satisfaction.setTeamAtmosphere((int) teamAtmosphereCell.getNumericCellValue());
        }
        if (workloadCell != null) {
            satisfaction.setWorkload((int) workloadCell.getNumericCellValue());
        }
        if (compagnySatisfactionScaleCell != null) {
            satisfaction.setCompagnySatisfactionScale((int) compagnySatisfactionScaleCell.getNumericCellValue());
        }
        if (satisfactionWithTechnicalLeaderCell != null) {
            satisfaction.setSatisfactionWithTechnicalLeader((int) satisfactionWithTechnicalLeaderCell.getNumericCellValue());
        }
        if (satisfactionWithTeamLeaderCell != null) {
            satisfaction.setSatisfactionWithTeamLeader((int) satisfactionWithTeamLeaderCell.getNumericCellValue());
        }
        if (satisfactionWithProjectCell != null) {
            satisfaction.setSatisfactionWithProject((int) satisfactionWithProjectCell.getNumericCellValue());
        }
        if (satisfactionWithGroupLeaderCell != null) {
            satisfaction.setSatisfactionWithGroupLeader((int) satisfactionWithGroupLeaderCell.getNumericCellValue());
        }
        if (satisfactionWithTeamBuildingCell != null) {
            satisfaction.setSatisfactionWithTeamBuilding((int) satisfactionWithTeamBuildingCell.getNumericCellValue());
        }
        if (satisfactionWithCareerPathCell != null) {
            satisfaction.setSatisfactionWithCareerPath((int) satisfactionWithCareerPathCell.getNumericCellValue());
        }
        if (didTheCompagnySatisfyYourAmbitionsCell != null) {
            satisfaction.setDidTheCompagnySatisfyYourAmbitions((int) didTheCompagnySatisfyYourAmbitionsCell.getNumericCellValue());
        }

        return SatisfactionAdapter.toSatisfactionDto(satisfaction);
    }

    private StabilityDto loadStability(Row row) {
        Stability stability = new Stability();

        Cell areYouActivelyLookingForJobOffersCell = row.getCell(11);
        Cell areYouOpenToTechnica_sOffersCell = row.getCell(14);

        if (areYouActivelyLookingForJobOffersCell != null) {
            stability.setAreYouActivelyLookingForJobOffers(areYouActivelyLookingForJobOffersCell.getStringCellValue());
        }
        if (areYouOpenToTechnica_sOffersCell != null) {
            stability.setAreYouOpenToTechnica_sOffers(areYouOpenToTechnica_sOffersCell.getStringCellValue());
        }

        return StabilityAdapter.toStabilityDto(stability);
    }

    private TechnicalEvaluationDto loadTechnicalEvaluation(Row row) {
        TechnicalEvaluation technicalEvaluation = new TechnicalEvaluation();

        Cell teamLeadScoreTechnicalKnowledgeAndExpertiseCell = row.getCell(37);
        Cell developerScoreTechnicalKnowledgeAndExpertiseCell = row.getCell(38);
        Cell teamLeadScoreQualityOfWorkCell = row.getCell(39);
        Cell developerScoreQualityOfWorkCell = row.getCell(40);
        Cell teamLeadScoreProactivityCell = row.getCell(41);
        Cell developerScoreProactivityCell = row.getCell(42);
        Cell teamLeadScoreSoftSkillsCell = row.getCell(43);
        Cell developerScoreSoftSkillsCell = row.getCell(44);
        Cell teamLeadScoreDisciplinary_RespectOfProcess_PunctualityCell = row.getCell(45);
        Cell developerScoreDisciplinary_RespectOfProcess_PunctualityCell = row.getCell(46);

        if (teamLeadScoreTechnicalKnowledgeAndExpertiseCell != null) {
            technicalEvaluation.setTeamLeadScoreTechnicalKnowledgeAndExpertise((int) teamLeadScoreTechnicalKnowledgeAndExpertiseCell.getNumericCellValue());
        }
        if (developerScoreTechnicalKnowledgeAndExpertiseCell != null) {
            technicalEvaluation.setDeveloperScoreTechnicalKnowledgeAndExpertise((int) developerScoreTechnicalKnowledgeAndExpertiseCell.getNumericCellValue());
        }
        if (teamLeadScoreQualityOfWorkCell != null) {
            technicalEvaluation.setTeamLeadScoreQualityOfWork((int) teamLeadScoreQualityOfWorkCell.getNumericCellValue());
        }
        if (developerScoreQualityOfWorkCell != null) {
            technicalEvaluation.setTeamLeadScoreQualityOfWork((int) developerScoreQualityOfWorkCell.getNumericCellValue());
        }
        if (teamLeadScoreProactivityCell != null) {
            technicalEvaluation.setTeamLeadScoreProactivity((int) teamLeadScoreProactivityCell.getNumericCellValue());
        }
        if (developerScoreProactivityCell != null) {
            technicalEvaluation.setDeveloperScoreProactivity((int) developerScoreProactivityCell.getNumericCellValue());
        }
        if (teamLeadScoreSoftSkillsCell != null) {
            technicalEvaluation.setTeamLeadScoreSoftSkills((int) teamLeadScoreSoftSkillsCell.getNumericCellValue());
        }
        if (developerScoreSoftSkillsCell != null) {
            technicalEvaluation.setTeamLeadScoreSoftSkills((int) developerScoreSoftSkillsCell.getNumericCellValue());
        }
        if (teamLeadScoreDisciplinary_RespectOfProcess_PunctualityCell != null) {
            technicalEvaluation.setTeamLeadScoreDisciplinary_RespectOfProcess_Punctuality((int) teamLeadScoreDisciplinary_RespectOfProcess_PunctualityCell.getNumericCellValue());
        }
        if (developerScoreDisciplinary_RespectOfProcess_PunctualityCell != null) {
            technicalEvaluation.setDeveloperScoreDisciplinary_RespectOfProcess_Punctuality((int) developerScoreDisciplinary_RespectOfProcess_PunctualityCell.getNumericCellValue());
        }

        return TechnicalEvaluationAdapter.toTechnicalEvaluationDto(technicalEvaluation);
    }

    private ObjectivesAndProactivityDto loadObjectivesAndProactivity(Row row) {
        ObjectivesAndProactivity objectivesAndProactivity = new ObjectivesAndProactivity();

        Cell lastYearObjectivesCell = row.getCell(16);
        Cell achievementsForLastYearCell = row.getCell(17);
        Cell targetsForNextYearCell = row.getCell(18);
        Cell keysAndToolsForTargetsSuccessCell = row.getCell(19);
        Cell didYouEverRaise_HighlightAProblemCell = row.getCell(20);
        Cell doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTaskCell = row.getCell(23);

        if (lastYearObjectivesCell != null) {
            objectivesAndProactivity.setLastYearObjectives(lastYearObjectivesCell.getStringCellValue());
        }
        if (achievementsForLastYearCell != null) {
            objectivesAndProactivity.setAchievementsForLastYear(achievementsForLastYearCell.getStringCellValue());
        }
        if (targetsForNextYearCell != null) {
            objectivesAndProactivity.setTargetsForNextYear(targetsForNextYearCell.getStringCellValue());
        }
        if (keysAndToolsForTargetsSuccessCell != null) {
            objectivesAndProactivity.setKeysAndToolsForTargetsSuccess(keysAndToolsForTargetsSuccessCell.getStringCellValue());
        }
        if (didYouEverRaise_HighlightAProblemCell != null) {
            objectivesAndProactivity.setDidYouEverRaise_HighlightAProblem(didYouEverRaise_HighlightAProblemCell.getStringCellValue());
        }
        if (doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTaskCell != null) {
            objectivesAndProactivity.setDoYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask(doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTaskCell.getStringCellValue());
        }

        return ObjectivesAndProactivityAdapter.toObjectivesAndProactivityDto(objectivesAndProactivity);
    }

    private CareerAndTrainingsDto loadCareerAndTrainings(Row row) {
        CareerAndTrainings careerAndTrainings = new CareerAndTrainings();

        Cell whichPathYouSeeItSuitableForYouCell = row.getCell(47);
        Cell doYouHaveTargetRoleOrPositionCell = row.getCell(48);
        Cell inOrderToReachYourObjective_RoleWhatDoYouRequestForTrainingCell = row.getCell(49);

        if (whichPathYouSeeItSuitableForYouCell != null) {
            careerAndTrainings.setWhichPathYouSeeItSuitableForYou(whichPathYouSeeItSuitableForYouCell.getStringCellValue());
        }
        if (doYouHaveTargetRoleOrPositionCell != null) {
            careerAndTrainings.setDoYouHaveTargetRoleOrPosition(doYouHaveTargetRoleOrPositionCell.getStringCellValue());
        }
        if (inOrderToReachYourObjective_RoleWhatDoYouRequestForTrainingCell != null) {
            careerAndTrainings.setInOrderToReachYourObjective_RoleWhatDoYouRequestForTraining(inOrderToReachYourObjective_RoleWhatDoYouRequestForTrainingCell.getStringCellValue());
        }

        return CareerAndTrainingsAdapter.toCareerAndTrainingsDto(careerAndTrainings);
    }

    private YearlyEvaluationDto loadYearlyEvaluation(Row row) {
        YearlyEvaluation yearlyEvaluation = new YearlyEvaluation();

        Cell salaryIncreaseCell = row.getCell(51);
        Cell gradeCell = row.getCell(52);
        Cell accumulativeScoreCell = row.getCell(53);
        Cell scoreToReachNextGradeCell = row.getCell(54);
        Cell satisfactionWithTheGradeCell = row.getCell(55);

        if (salaryIncreaseCell != null) {
            yearlyEvaluation.setSalaryIncrease((float) salaryIncreaseCell.getNumericCellValue());
        }
        if (gradeCell != null) {
            yearlyEvaluation.setGrade(gradeCell.getStringCellValue());
        }
        if (accumulativeScoreCell != null) {
            yearlyEvaluation.setAccumulativeScore((float) accumulativeScoreCell.getNumericCellValue());
        }
        if (scoreToReachNextGradeCell != null) {
            yearlyEvaluation.setScoreToReachNextGrade((int) scoreToReachNextGradeCell.getNumericCellValue());
        }
        if (satisfactionWithTheGradeCell != null) {
            yearlyEvaluation.setSatisfactionWithTheGrade(satisfactionWithTheGradeCell.getStringCellValue());
        }

        return YearlyEvaluationAdapter.toYearlyEvaluationDto(yearlyEvaluation);
    }

    @Override
    public List<EmployeeSummary> getAllEmployeesSummary() {
        List<EmployeeDto> employeeDtos = employeeRepository.findAll();
        List<EmployeeSummary> employeeSummaries = new ArrayList<>();

        for (EmployeeDto employeeDto : employeeDtos) {
            EmployeeSummary summary = new EmployeeSummary();
            summary.setId(employeeDto.getId());
            summary.setDepartment(employeeDto.getDepartment());
            summary.setTeam(employeeDto.getTeam());
            summary.setNameAndSurname(employeeDto.getNameAndSurname());
            employeeSummaries.add(summary);
        }

        return employeeSummaries;
    }

    @Override
    public EmployeeDetails getEmployeeDetailsById(Long id) {
        Optional<EmployeeDto> employeeDtoOptional = employeeRepository.findById(id);

        EmployeeDto employeeDto = employeeDtoOptional.get();

        EmployeeDetails employeeDetails = EmployeeAdapter.toEmployeeDetails(employeeDto);

        return employeeDetails;
    }

    @Override
    public EmployeeDetails updateEmployeeDetails(Long id, EmployeeDetails updatedEmployee) {
        Optional<EmployeeDto> employeeDtoOptional = employeeRepository.findById(id);

        EmployeeDto existingEmployee = employeeDtoOptional.get();

        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setTeam(updatedEmployee.getTeam());
        existingEmployee.setNameAndSurname(updatedEmployee.getNameAndSurname());
        existingEmployee.setJobTitle(updatedEmployee.getJobTitle());
        existingEmployee.setEmploymentDate(updatedEmployee.getEmploymentDate());
        existingEmployee.setEmploymentType(updatedEmployee.getEmploymentType());
        existingEmployee.setGrade(updatedEmployee.getGrade());
        existingEmployee.setLastEvaluationScore(updatedEmployee.getLastEvaluationScore());
        existingEmployee.setCurrentEvaluationScore(updatedEmployee.getCurrentEvaluationScore());
        existingEmployee.setReviewDate(updatedEmployee.getReviewDate());
        existingEmployee.setReviewer(updatedEmployee.getReviewer());

        SatisfactionDto satisfactionDto = SatisfactionAdapter.toSatisfactionDto(updatedEmployee.getSatisfaction());
        existingEmployee.setSatisfaction(satisfactionDto);

        StabilityDto stabilityDto = StabilityAdapter.toStabilityDto(updatedEmployee.getStability());
        existingEmployee.setStability(stabilityDto);

        TechnicalEvaluationDto technicalEvaluationDto = TechnicalEvaluationAdapter.toTechnicalEvaluationDto(updatedEmployee.getTechnicalEvaluation());
        existingEmployee.setTechnicalEvaluation(technicalEvaluationDto);

        ObjectivesAndProactivityDto objectivesAndProactivityDto = ObjectivesAndProactivityAdapter.toObjectivesAndProactivityDto(updatedEmployee.getObjectivesAndProactivity());
        existingEmployee.setObjectivesAndProactivity(objectivesAndProactivityDto);

        CareerAndTrainingsDto careerAndTrainingsDto = CareerAndTrainingsAdapter.toCareerAndTrainingsDto(updatedEmployee.getCareerAndTrainings());
        existingEmployee.setCareerAndTrainings(careerAndTrainingsDto);

        YearlyEvaluationDto yearlyEvaluationDto = YearlyEvaluationAdapter.toYearlyEvaluationDto(updatedEmployee.getYearlyEvaluation());
        existingEmployee.setYearlyEvaluation(yearlyEvaluationDto);

        employeeRepository.save(existingEmployee);

        return EmployeeAdapter.toEmployeeDetails(existingEmployee);
    }
}
