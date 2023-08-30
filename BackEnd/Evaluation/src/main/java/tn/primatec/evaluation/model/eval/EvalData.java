package tn.primatec.evaluation.model.eval;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import tn.primatec.evaluation.model.employee.Employee;

@Data
@Builder
@Jacksonized
public class EvalData {
    private Employee employee;
    private String stability;

    public EvalData() {
    }

    public EvalData(Employee employee, String stability) {
        this.employee = employee;
        this.stability = stability;
    }
}
