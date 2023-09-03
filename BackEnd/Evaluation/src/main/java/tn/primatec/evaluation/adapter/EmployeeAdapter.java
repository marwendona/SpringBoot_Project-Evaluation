package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.model.employee.EmployeeDetails;
import tn.primatec.evaluation.model.eval.*;

public class EmployeeAdapter {
    public static EmployeeDetails toEmployeeDetails(EmployeeDto employeeDto) {
        var employeeDetails = new EmployeeDetails();
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
