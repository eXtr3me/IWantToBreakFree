package org.academiadecodigo.variachis.delta.back_end.converters;

import org.academiadecodigo.variachis.delta.back_end.dto.DiaryEntryDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.DiaryEntry;
import org.springframework.stereotype.Component;

@Component
public class DiaryEntryToDiaryentryDTO {

    public DiaryEntryDTO convert(DiaryEntry diaryEntry) {

        DiaryEntryDTO diaryEntryDTO = new DiaryEntryDTO();
        diaryEntryDTO.setId(diaryEntry.getId());
        diaryEntryDTO.setDate(diaryEntry.getDate());
        diaryEntryDTO.setNumberOfSmokedCigarretes(diaryEntry.getNumberOfSmokedCigarrettes());
        diaryEntryDTO.setMoneySpent(diaryEntry.getMoneySpent());

        return diaryEntryDTO;
    }

}
