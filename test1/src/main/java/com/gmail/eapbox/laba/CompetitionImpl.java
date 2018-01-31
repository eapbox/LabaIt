package com.gmail.eapbox.laba;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eapbox on 30.01.2018.
 */
public class CompetitionImpl implements Competition {

    public Integer getSteps(String task) throws ValidateException {
        List<Integer> taskList = new ArrayList<Integer>();

        if (!validateTask(task)) return null;
        for (String el : task.split("\\s+")) {
            taskList.add(Integer.parseInt(el));
        }
        int steps = getStep(taskList);

        return steps;
    }

    public int getStep(List<Integer> taskList) {
        int steps = getStepRec(taskList, 0, 0, 0);
        return steps;
    }

    private Integer getStepRec(List<Integer> taskList, int index, int countStep, int curPosition) {
        int nextStep = taskList.get(index);
        int length = taskList.size();

        //смотрим, не выходим ли за рамки
        if (((nextStep % 2) == 0) && ((curPosition + nextStep) > length) ||     //не можем двигаться вперед
            ((nextStep % 2) != 0) && ((curPosition - nextStep) < 0)) {         //не можем двигаться назад
            return (countStep + curPosition);
        }

        //за рамки не вышли----------------------------------
        //определяем текущее положение
        if ((nextStep % 2) == 0)
            curPosition += nextStep;
        if ((nextStep % 2) != 0)
            curPosition -= nextStep;

        countStep = countStep + nextStep;
        index++;
        if (index == length)
            return countStep;

        countStep = getStepRec(taskList, index, countStep, curPosition);
        return countStep;
    }

    private boolean validateTask(String task) throws ValidateException {
        Pattern p = Pattern.compile("^[\\d+\\s*]+$");
        Matcher m = p.matcher(task);

        if (!m.matches()) {
            throw new ValidateException("You need enter a correct task!");
        }
        return true;
    }
}
