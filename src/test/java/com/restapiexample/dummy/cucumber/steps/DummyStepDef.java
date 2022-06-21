package com.restapiexample.dummy.cucumber.steps;

import com.restapiexample.dummy.employeesinfo.EmployeesSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import java.util.HashMap;

public class DummyStepDef {
    static ValidatableResponse response;
    static String name1;
    static String salary1;
    static String age;
    static int id;
    @Steps
    EmployeesSteps employeeSteps;


    @When("^I Create a new employee by providing the information name \"([^\"]*)\" salary \"([^\"]*)\" age \"([^\"]*)\"$")
    public void iCreateANewEmployeeByProvidingTheInformationNameSalaryAge(String name, String salary, String age)  {
        response =employeeSteps.createEmployee(name,salary,age);
        id= response.log().all().extract().path("data.id");


    }

    @And("^I verify that the employee has been created$")
    public void iVerifyThatTheEmployeeHasBeenCreated() {
        HashMap<String,Object> employeeMap= employeeSteps.getEmployeeInfoById(id);
        System.out.println(employeeMap);

        response = employeeSteps.getEmployeeInfoByIdAndReturnResponse(id);
        System.out.println(response);
        String name_Extracted;
        name_Extracted= response.log().all().extract().path("data.employee_name");
        System.out.println(name_Extracted);

    }

    @And("^I updated a name of the employee created$")
    public void iUpdatedANameOfTheEmployeeCreated() {

    }
    @And("^I Verify that the employee's name has been updated$")
    public void iVerifyThatTheEmployeeSNameHasBeenUpdated() {

    }

    @And("^I delete employee with same id$")
    public void iDeleteEmployeeWithSameId() {

    }

    @Then("^I verify the employee has been deleted$")
    public void iVerifyTheEmployeeHasBeenDeleted() {


    }



}
