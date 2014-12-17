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
import java.util.List;
/**
 *
 * @author Jon
 */
@WebService(serviceName = "RuleBaseService")
public class RuleBaseService
{

    /**
     * Web service operation
     * @param ssn
     * @param loanAmount
     * @param loanDuration
     * @param creditScore
     * @return 
     */
    @WebMethod(operationName = "chooseAppropriateBank")
    public List<String> chooseAppropriateBank(@WebParam(name = "ssn") String ssn, @WebParam(name = "loanAmount") double loanAmount, @WebParam(name = "loanDuration") int loanDuration, @WebParam(name = "creditScore") int creditScore)
    {
        Controller controller = new Controller(ssn, loanAmount, loanDuration, creditScore);
        return controller.selectSuitableBanks();
    }
}
