/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.rulebasews.service;

import dk.rulebasews.controller.Controller;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jon
 */
@WebService(serviceName = "RuleBaseWS")
public class RuleBaseWS
{

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt)
    {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "chooseAppropriateBanks")
    public java.util.List<java.lang.String> chooseAppropriateBanks(@WebParam(name = "ssn") String ssn, @WebParam(name = "loanAmount") double loanAmount, @WebParam(name = "loanDuration") int loanDuration, @WebParam(name = "creditScore") int creditScore)
    {
        Controller controller = new Controller(ssn, loanAmount, loanDuration, creditScore);
        return controller.selectSuitableBanks();
    }
}
