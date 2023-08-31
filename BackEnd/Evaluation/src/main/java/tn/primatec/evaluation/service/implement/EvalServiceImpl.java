package tn.primatec.evaluation.service.implement;

import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.primatec.evaluation.adapter.EmployeeAdapter;
import tn.primatec.evaluation.dao.EmployeeRepository;
import tn.primatec.evaluation.dao.SatisfactionRepository;
import tn.primatec.evaluation.model.Employee;
import tn.primatec.evaluation.model.eval.*;
import tn.primatec.evaluation.service.EvalService;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class EvalServiceImpl implements EvalService {

    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private EmployeeRepository employeeRepository;
    private SatisfactionRepository satisfactionRepository;

    @Autowired
    public EvalServiceImpl(EmployeeRepository employeeRepository, SatisfactionRepository satisfactionRepository) {
        this.employeeRepository = employeeRepository;
        this.satisfactionRepository = satisfactionRepository;
    }

    @Override
    public List<Employee> loadEmployeesFromExcel(String filePath) throws Exception {
        List<Employee> employees = new ArrayList<>();

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

            employees.add(employee);
            employeeRepository.save(EmployeeAdapter.toEmployeeDto(employee));
        }

        fileInputStream.close();
        return employees;
    }

    @Override
    public List<Satisfaction> loadSatisfactionsFromExcel(String filePath) throws IOException {
        List<Satisfaction> satisfactions = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
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

            satisfactions.add(satisfaction);
        }

        fileInputStream.close();
        return satisfactions;
    }

    @Override
    public List<Stability> loadStabilitiesFromExcel(String filePath) throws IOException {
        List<Stability> stabilities = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Stability stability = new Stability();

            Cell areYouActivelyLookingForJobOffersCell = row.getCell(11);
            Cell areYouOpenToTechnica_sOffersCell = row.getCell(14);

            if (areYouActivelyLookingForJobOffersCell != null) {
                stability.setAreYouActivelyLookingForJobOffers(areYouActivelyLookingForJobOffersCell.getStringCellValue());
            }

            if (areYouOpenToTechnica_sOffersCell != null) {
                stability.setAreYouOpenToTechnica_sOffers(areYouOpenToTechnica_sOffersCell.getStringCellValue());
            }

            stabilities.add(stability);
        }

        fileInputStream.close();
        return stabilities;
    }

    @Override
    public List<TechnicalEvaluation> loadTechnicalEvaluationsFromExcel(String filePath) throws IOException {
        List<TechnicalEvaluation> technicalEvaluations = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
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

            technicalEvaluations.add(technicalEvaluation);
        }

        fileInputStream.close();
        return technicalEvaluations;
    }

    @Override
    public List<ObjectivesAndProactivity> loadObjectivesAndProactivitiesFromExcel(String filePath) throws IOException {
        List<ObjectivesAndProactivity> objectivesAndProactivities = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
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

            objectivesAndProactivities.add(objectivesAndProactivity);
        }

        fileInputStream.close();
        return objectivesAndProactivities;
    }

    @Override
    public List<CareerAndTrainings> loadCareersAndTrainingsFromExcel(String filePath) throws IOException {
        List<CareerAndTrainings> careersAndTrainings = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
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

            careersAndTrainings.add(careerAndTrainings);
        }

        fileInputStream.close();
        return careersAndTrainings;
    }

    @Override
    public List<YearlyEvaluation> loadYearlyEvaluationFromExcel(String filePath) throws IOException {
        List<YearlyEvaluation> yearlyEvaluations = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
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

            yearlyEvaluations.add(yearlyEvaluation);
        }

        fileInputStream.close();
        return yearlyEvaluations;
    }
}
