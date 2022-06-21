package com.restapiexample.dummy.employeesinfo;


import com.restapiexample.dummy.constants.EndPoints;
import com.restapiexample.dummy.model.EmployeesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;



public class EmployeesSteps {


    @Step("Creating employee with name : {0}, Salary : {1}, Age : {2}")
    public ValidatableResponse createEmployee(String name, String salary, String age) {

        EmployeesPojo employeePojo = new EmployeesPojo();
        employeePojo.setName(name);
        employeePojo.setSalary(salary);
        employeePojo.setAge(age);
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(employeePojo)
                .when()
                .post(EndPoints.CREATE_EMPLOYEE)
                .then();
    }

    @Step("Getting the employee information with ID : {0}")
    public HashMap<String, Object> getEmployeeInfoById(int iD) {
        HashMap<String, Object> employeeMap = SerenityRest.given().log().all()
                .when()
                .pathParam("id", iD)
                .get(EndPoints.GET_SINGLE_EMPLOYEE)
                .then()
                .extract()
                .path("");
        return employeeMap;


    }

    @Step("Getting the employee information with ID : {0}")
    public ValidatableResponse getEmployeeInfoByIdAndReturnResponse(int iD) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", iD)
                .when()
                .get(EndPoints.GET_SINGLE_EMPLOYEE)
                .then();
    }


    @Step("Updating employee information with id : {0}, name : {2}")
    public ValidatableResponse updateEmployeeDetails(int iD, String name, String salary, String age) {

        EmployeesPojo employeePojo = new EmployeesPojo();
        employeePojo.setName(name);
        employeePojo.setSalary(salary);
        employeePojo.setAge(age);

        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("id", iD)
                .body(employeePojo)
                .when()
                .put(EndPoints.UPDATE_EMPLOYEE)
                .then();
    }

    @Step
    public ValidatableResponse deleteEmployee(int iD) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", iD)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE)
                .then();
    }


}
