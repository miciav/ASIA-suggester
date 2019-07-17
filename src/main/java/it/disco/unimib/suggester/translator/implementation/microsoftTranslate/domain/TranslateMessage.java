package it.disco.unimib.suggester.translator.implementation.microsoftTranslate.domain;


import it.disco.unimib.suggester.model.LanguageType;
import it.disco.unimib.suggester.translator.domain.ITranslation;
import it.disco.unimib.suggester.translator.domain.ITranslationBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslateMessage implements ITranslation {
    private DetectedLanguage detectedLanguage;
    private List<Translation> translations;

    @Override
    public String getLanguage() {
        return detectedLanguage.getLanguage();
    }

    @Override
    public LanguageType getLanguageEnum() {
        return null;
    }

    @Override
    public Double getScore() {
        return detectedLanguage.getScore();
    }

    @Override
    public List<? extends ITranslationBase> getTranslations() {
        return translations;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class DetectedLanguage {
        private String language;
        private Double score;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Translation implements ITranslationBase {
        private String text;
        private String to;

        @Override
        public String getDestLanguage() {
            return to;
        }
    }

}




