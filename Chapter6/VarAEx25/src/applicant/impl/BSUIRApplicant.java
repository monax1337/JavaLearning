package applicant.impl;

import applicant.Applicant;

public class BSUIRApplicant implements Applicant {
    @Override
    public void obtainCertificate() {
        System.out.println("Получение аттестата для абитуриента БГУИР.");
    }

    @Override
    public void fillApplication() {
        System.out.println("Заполнение заявления для абитуриента БГУИР.");
    }

    @Override
    public void registerForExams() {
        System.out.println("Регистрация на вступительные испытания для абитуриента БГУИР.");
    }

    @Override
    public void submitDocuments() {
        System.out.println("Подача документов для абитуриента БГУИР.");
    }

    public void admissionRules() {
        System.out.println("Узнать правила приема для абитуриента БГУИР.");
    }
}
