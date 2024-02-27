package applicant.impl;

import applicant.Applicant;

public class BSUApplicant implements Applicant {
    @Override
    public void obtainCertificate() {
        System.out.println("Получение аттестата для абитуриента БГУ.");
    }

    @Override
    public void fillApplication() {
        System.out.println("Заполнение заявления для абитуриента БГУ.");
    }

    @Override
    public void registerForExams() {
        System.out.println("Регистрация на вступительные испытания для абитуриента БГУ.");
    }

    @Override
    public void submitDocuments() {
        System.out.println("Подача документов для абитуриента БГУ.");
    }

    @Deprecated
    public void scholarshipProcedure() {
        System.out.println("Узнать про процедуру оформления стипендии для абитуриента БГУ.");
    }
}
