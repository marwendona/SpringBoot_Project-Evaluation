package tn.primatec.evaluation.service.implement;

import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.primatec.evaluation.adapter.*;
import tn.primatec.evaluation.dao.*;
import tn.primatec.evaluation.dto.*;
import tn.primatec.evaluation.model.employee.Employee;
import tn.primatec.evaluation.model.employee.EmployeeDetails;
import tn.primatec.evaluation.model.eval.*;
import tn.primatec.evaluation.service.EvalService;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Optional;

@Service
@Transactional
public class EvalServiceImpl implements EvalService {
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private EmployeeRepository employeeRepository;
    private SatisfactionRepository satisfactionRepository;
    private StabilityRepository stabilityRepository;
    private TechnicalEvaluationRepository technicalEvaluationRepository;
    private ObjectivesAndProactivityRepository objectivesAndProactivityRepository;
    private CareerAndTrainingsRepository careerAndTrainingsRepository;
    private YearlyEvaluationRepository yearlyEvaluationRepository;

    @Autowired
    public EvalServiceImpl(EmployeeRepository employeeRepository, SatisfactionRepository satisfactionRepository, StabilityRepository stabilityRepository, TechnicalEvaluationRepository technicalEvaluationRepository, ObjectivesAndProactivityRepository objectivesAndProactivityRepository, CareerAndTrainingsRepository careerAndTrainingsRepository, YearlyEvaluationRepository yearlyEvaluationRepository) {
        this.employeeRepository = employeeRepository;
        this.satisfactionRepository = satisfactionRepository;
        this.stabilityRepository = stabilityRepository;
        this.technicalEvaluationRepository = technicalEvaluationRepository;
        this.objectivesAndProactivityRepository = objectivesAndProactivityRepository;
        this.careerAndTrainingsRepository = careerAndTrainingsRepository;
        this.yearlyEvaluationRepository = yearlyEvaluationRepository;
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
        Employee employee = new Employee();

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
            employee.setDepartment(departmentCell.getStringCellValue());
        }
        if (teamCell != null) {
            employee.setTeam(teamCell.getStringCellValue());
        }
        if (nameAndSurnameCell != null) {
            employee.setNameAndSurname(nameAndSurnameCell.getStringCellValue());
        }
        if (jobTitleCell != null) {
            employee.setJobTitle(jobTitleCell.getStringCellValue());
        }
        if (employmentDateCell != null) {
            employee.setEmploymentDate(dateFormat.parse(employmentDateCell.getStringCellValue()));
        }
        if (employmentTypeCell != null) {
            employee.setEmploymentType(employmentTypeCell.getStringCellValue());
        }
        if (gradeCell != null) {
            employee.setGrade(gradeCell.getStringCellValue());
        }
        if (lastEvaluationScoreCell != null) {
            employee.setLastEvaluationScore(lastEvaluationScoreCell.getNumericCellValue());
        }
        if (currentEvaluationScoreCell != null) {
            employee.setCurrentEvaluationScore(currentEvaluationScoreCell.getNumericCellValue());
        }
        if (reviewDateCell != null) {
            employee.setReviewDate(dateFormat.parse(reviewDateCell.getStringCellValue()));
        }
        if (reviewerCell != null) {
            employee.setReviewer(reviewerCell.getStringCellValue());
        }

        EmployeeDto employeeDto = EmployeeAdapter.toEmployeeDto(employee);

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

        SatisfactionDto satisfactionDto = SatisfactionAdapter.toSatisfactionDto(satisfaction);

        return satisfactionDto;
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

        StabilityDto stabilityDto = StabilityAdapter.toStabilityDto(stability);

        return stabilityDto;
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

        TechnicalEvaluationDto technicalEvaluationDto = TechnicalEvaluationAdapter.toTechnicalEvaluationDto(technicalEvaluation);

        return technicalEvaluationDto;
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

        ObjectivesAndProactivityDto objectivesAndProactivityDto = ObjectivesAndProactivityAdapter.toObjectivesAndProactivityDto(objectivesAndProactivity);

        return objectivesAndProactivityDto;
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

        CareerAndTrainingsDto careerAndTrainingsDto = CareerAndTrainingsAdapter.toCareerAndTrainingsDto(careerAndTrainings);

        return careerAndTrainingsDto;
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

        YearlyEvaluationDto yearlyEvaluationDto = YearlyEvaluationAdapter.toYearlyEvaluationDto(yearlyEvaluation);

        return yearlyEvaluationDto;
    }

    @Override
    public EmployeeDetails getEmployeeDetailsById(Long id) {
        Optional<EmployeeDto> employeeDtoOptional = employeeRepository.findById(id);

        EmployeeDto employeeDto = employeeDtoOptional.get();
        EmployeeDetails employeeDetails = new EmployeeDetails();

        employeeDetails.setDepartment(employeeDto.getDepartment());
        employeeDetails.setTeam(employeeDto.getTeam());
        employeeDetails.setNameAndSurname(employeeDto.getNameAndSurname());
        employeeDetails.setJobTitle(employeeDto.getJobTitle());
        employeeDetails.setEmploymentDate(employeeDto.getEmploymentDate());
        employeeDetails.setEmploymentType(employeeDto.getEmploymentType());
        employeeDetails.setGrade(employeeDto.getGrade());
        employeeDetails.setLastEvaluationScore(employeeDto.getLastEvaluationScore());
        employeeDetails.setCurrentEvaluationScore(employeeDto.getCurrentEvaluationScore());
        employeeDetails.setReviewDate(employeeDto.getReviewDate());
        employeeDetails.setReviewer(employeeDto.getReviewer());

        Satisfaction satisfaction = SatisfactionAdapter.toSatisfaction(employeeDto.getSatisfaction());
        employeeDetails.setSatisfaction(satisfaction);

        Stability stability = StabilityAdapter.toStability(employeeDto.getStability());
        employeeDetails.setStability(stability);

        TechnicalEvaluation technicalEvaluation = TechnicalEvaluationAdapter.toTechnicalEvaluation(employeeDto.getTechnicalEvaluation());
        employeeDetails.setTechnicalEvaluation(technicalEvaluation);

        ObjectivesAndProactivity objectivesAndProactivity = ObjectivesAndProactivityAdapter.toObjectivesAndProactivity(employeeDto.getObjectivesAndProactivity());
        employeeDetails.setObjectivesAndProactivity(objectivesAndProactivity);

        CareerAndTrainings careerAndTrainings = CareerAndTrainingsAdapter.toCareerAndTrainings(employeeDto.getCareerAndTrainings());
        employeeDetails.setCareerAndTrainings(careerAndTrainings);

        YearlyEvaluation yearlyEvaluation = YearlyEvaluationAdapter.toYearlyEvaluation(employeeDto.getYearlyEvaluation());
        employeeDetails.setYearlyEvaluation(yearlyEvaluation);

        return employeeDetails;
    }
}
