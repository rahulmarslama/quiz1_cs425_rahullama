package miu.rahul;

import miu.rahul.service.AccountService;
import miu.rahul.service.AccountServiceImpl;
import miu.rahul.utility.JSONUtil;

public class CAMSApp {
    private final AccountService accountService;

    public CAMSApp() {
        this.accountService = new AccountServiceImpl();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, OKalu!\nWelcome to the CAMS CLI Application.");
        CAMSApp app = new CAMSApp();
        app.printAllAccounts();
        app.printBankLiquidity(); 
        app.printPlatinumTierAccounts();

    }

    private void printAllAccounts() {
        System.out.println("All Accounts:");
        var allAccounts = accountService.getAllAccounts();
        System.out.println(JSONUtil.convertListToJson(allAccounts));
    }

    private void printSilverTierAccounts() {
        System.out.println("Silver Tier Accounts:");
        var silverTierAccounts = accountService.getSilverTierAccounts();
        System.out.println(JSONUtil.convertListToJson(silverTierAccounts));
    }

    private void printGoldTierAccounts() {
        System.out.println("Gold Tier Accounts:");
        var goldTierAccounts = accountService.getGoldTierAccounts();
        System.out.println(JSONUtil.convertListToJson(goldTierAccounts));
    }

    private void printPlatinumTierAccounts() {
        System.out.println("Platinum Tier Accounts:");
        var platinumTierAccounts = accountService.getPlatinumTierAccounts();
        System.out.println(JSONUtil.convertListToJson(platinumTierAccounts));
    }

    private void printBankLiquidity() {
    System.out.println("Total Bank Liquidity:");
    var liquidity = accountService.computeTotalLiquidity();
    System.out.println(String.format("$%,.2f", liquidity)); 
}
}
