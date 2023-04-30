package com.github.egosteva.tests;

import com.github.egosteva.pages.RegistrationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.github.egosteva.tests.RandomRegistrationTestData.*;
import static io.qameta.allure.Allure.step;

@Feature("Student registration form")
@DisplayName("Student registration form")
public class PracticeFormWithPageObjectsRandomDataTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Story("Fill registration form")
    @Owner("egosteva")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Student registration form", url = "https://demoqa.com/automation-practice-form/")
    @DisplayName("Fill registration form and check results")
    @Tag("web")
    void fillPracticeFormTest() {
        step("Open registration form",
                () ->
                        registrationPage.openPage())
                .removeBanners();
        step("Fill form",
                () -> {
                    registrationPage.setFirstName(firstName)
                            .setLastName(lastName)
                            .setUserEmail(email)
                            .setGender(gender)
                            .setPhoneNumber(phone)
                            .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                            .setSubject(subject)
                            .setHobby(hobby)
                            .uploadPicture(imageName)
                            .setCurrentAddress(currentAddress)
                            .setState(state)
                            .setCity(city)
                            .clickSubmit();
                });
        step("Check results",
                () -> {
                    registrationPage.checkResultsModalAppears()
                            .checkResult("Student Name", firstName + " " + lastName)
                            .checkResult("Student Email", email)
                            .checkResult("Gender", gender)
                            .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                            .checkResult("Subjects", subject)
                            .checkResult("Hobbies", hobby)
                            .checkResult("Picture", imageName)
                            .checkResult("Address", currentAddress)
                            .checkResult("State and City", state + " " + city);
                });
    }
}
