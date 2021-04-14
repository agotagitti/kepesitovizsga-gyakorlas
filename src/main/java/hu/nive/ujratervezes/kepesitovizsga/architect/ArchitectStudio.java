package hu.nive.ujratervezes.kepesitovizsga.architect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArchitectStudio {

    private Map<String, Plan> plans = new HashMap<>();

    public void addPlan(String workingTitle, Plan plan) {
        if (plan == null || workingTitle == null || workingTitle.isBlank()) {
            throw new IllegalArgumentException("Working title and plan must not be empty!");
        }
        plans.put(workingTitle, plan);
    }

    public Plan getPlanWithMaxSquareMeter() {
        int sqrMeter = 0;
        Plan plan = null;
        for (Map.Entry<String, Plan> actualPlan : plans.entrySet()) {
            if (actualPlan.getValue().calculateSquareMeter() > sqrMeter) {
                sqrMeter = actualPlan.getValue().calculateSquareMeter();
                plan = actualPlan.getValue();
            }
        }
        return plan;
    }

    public Plan getPlanByWorkingTitle(String workingTitle) {
        if (workingTitle == null || workingTitle.isBlank()) {
            throw new IllegalArgumentException("Working title must not be empty!");
        }
        for (Map.Entry<String, Plan> actualPlan : plans.entrySet()) {
            if (actualPlan.getKey().equals(workingTitle)) {
                return actualPlan.getValue();
            }
        }
        throw new IllegalArgumentException("No such project.");
    }

    public Plan getPlanByProjectName(String projectName) {
        if (projectName == null || projectName.isBlank()) {
            throw new IllegalArgumentException("Project name must not be empty!");
        }
        for (Map.Entry<String, Plan> actualPlan : plans.entrySet()) {
            if (actualPlan.getValue().getProjectName().equals(projectName)) {
                return actualPlan.getValue();
            }
        }
        throw new IllegalArgumentException("No such project.");
    }

    public List<Plan> getSmallerPlans(int squareMeter) {
        List<Plan> smallPlans = new ArrayList<>();
        for (Map.Entry<String, Plan> actualPlan : plans.entrySet()) {
            if (actualPlan.getValue().calculateSquareMeter() < squareMeter) {
                smallPlans.add(actualPlan.getValue());
            }
        }
        return smallPlans;
    }

    public List<Plan> getListOfPlansByPlanType(PlanType type) {
        if (type == null) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }
        List<Plan> plansByType = new ArrayList<>();
        for (Map.Entry<String, Plan> actualPlan : plans.entrySet()) {
            if (actualPlan.getValue().getType().equals(type)) {
                plansByType.add(actualPlan.getValue());
            }
        }
        return plansByType;
    }

}
