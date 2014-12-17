/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.rulebasews.controller;

import dk.rulebasews.dto.LoanRequestDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marekrigan
 */
public class Controller 
{
    private LoanRequestDTO requestDTO;
    private List<String> bankList;
    public Controller()
    {
        requestDTO = new LoanRequestDTO();
        bankList = generateBankList();
    }
        
    public Controller(String ssn, double loanAmount,int loanDuration, int creditScore)
    {
        requestDTO = new LoanRequestDTO(ssn, loanAmount, loanDuration, creditScore );
        bankList = generateBankList();
    }
    
    private List<String> generateBankList()
    {
        List<String> generatingBankList = new ArrayList<String>();
        
        generatingBankList.add("cphbusiness.bankJSON");
        generatingBankList.add("cphbusiness.bankXML");
        generatingBankList.add("cphbusiness.wsBank");
        generatingBankList.add("cphbusiness.rabbitBank");
        
        return generatingBankList;
    }
    
    public List<String> selectSuitableBanks()
    {
        List<String> selectedBanks = new ArrayList<String>();
        
        int creditScore = requestDTO.getCreditScore();
        
        if (creditScore < 580)
        {
            return null;
        }
        
        if (creditScore >= 720)
        {
            selectedBanks.add(bankList.get(3));
            selectedBanks.add(bankList.get(2));
            selectedBanks.add(bankList.get(1));
            selectedBanks.add(bankList.get(0));
        }
        if (creditScore >= 680 && creditScore <= 719)
        {
            selectedBanks.add(bankList.get(2));
            selectedBanks.add(bankList.get(1));
            selectedBanks.add(bankList.get(0));
        }
        if (creditScore >= 620 && creditScore <= 679)
        {
            selectedBanks.add(bankList.get(1));
            selectedBanks.add(bankList.get(0));
        }
        if (creditScore >= 580 && creditScore <= 619)
        {
            selectedBanks.add(bankList.get(0));
        }
        
        return selectedBanks;
    }
    
}
