package org.academiadecodigo.variachis.delta.back_end.dto;

import javax.validation.constraints.NotNull;

public class DiaryOutDTO {

    @NotNull
    private Integer numberOfSmokedCigarrettes;

    public Integer getNumberOfSmokedCigarrettes() {
        return numberOfSmokedCigarrettes;
    }

    public void setNumberOfSmokedCigarrettes(Integer numberOfSmokedCigarrettes) {
        this.numberOfSmokedCigarrettes = numberOfSmokedCigarrettes;
    }

    @Override
    public String toString() {
        return "DiaryOutDTO{" +
                "numberOfSmokedCigarrettes=" + numberOfSmokedCigarrettes +
                '}';
    }
}
