package fundamentaldata;


import com.crazzyghost.alphavantage.fundamentaldata.response.*;
import org.junit.Before;
import org.junit.Test;
import util.TestUtils;

import java.io.IOException;

import static org.junit.Assert.*;
import static util.TestUtils.*;

public class FundamentalDataResponseTest {

    @Before
    public void setUp(){
        TestUtils.forDirectory("fundamentaldata");
    }

    @Test
    public void testBalanceSheetResponse() throws IOException {
        BalanceSheetResponse response = BalanceSheetResponse.of(json("balancesheet"));
        assertEquals(response.getAnnualReports().size(), 2);
        assertEquals(response.getQuarterlyReports().size(), 3);
        assertNull(response.getErrorMessage());
        assertEquals(response.getSymbol(), "IBM");

        BalanceSheet annualSheet = response.getAnnualReports().get(0);
        assertNotNull(annualSheet.toString());

        assertEquals(annualSheet.getFiscalDateEnding(), "2020-12-31");
        assertEquals(annualSheet.getReportedCurrency(), "USD");
        assertEquals(annualSheet.getTotalAssets(), 155971000000L, 0.0);
        assertEquals(annualSheet.getTotalCurrentAssets(), 39165000000L, 0.0);
        assertEquals(annualSheet.getCashAndCashEquivalentsAtCarryingValue(), 13212000000L, 0.0);
        assertEquals(annualSheet.getCashAndShortTermInvestments(), 13812000000L, 0.0);
        assertEquals(annualSheet.getInventory(), 1839000000L, 0.0);
        assertEquals(annualSheet.getCurrentNetReceivables(), 18738000000L, 0.0);
        assertEquals(annualSheet.getTotalNonCurrentAssets(), 115864000000L, 0.0);
        assertEquals(annualSheet.getPropertyPlantEquipment(), 10040000000L, 0.0);
        assertEquals(annualSheet.getAccumulatedDepreciationAmortizationPPE(), 23136000000L, 0.0);
        assertEquals(annualSheet.getIntangibleAssets(), 73413000000L, 0.0);
        assertEquals(annualSheet.getIntangibleAssetsExcludingGoodwill(), 13796000000L, 0.0);
        assertEquals(annualSheet.getGoodWill(), 59617000000L, 0.0);
        assertEquals(annualSheet.getInvestments(), 923000000L, 0.0);
        assertEquals(annualSheet.getLongTermInvestments(), 172000000L, 0.0);
        assertEquals(annualSheet.getShortTermInvestments(), 600000000L, 0.0);
        assertEquals(annualSheet.getOtherCurrentAssets(), 4313000000L, 0.0);
        assertEquals(annualSheet.getOtherNonCurrentAssets(), 227000000L, 0.0);
        assertEquals(annualSheet.getTotalLiabilities(), 135244000000L, 0.0);
        assertEquals(annualSheet.getTotalCurrentLiabilities(), 39869000000L, 0.0);
        assertEquals(annualSheet.getCurrentAccountsPayable(), 4908000000L, 0.0);
        assertEquals(annualSheet.getDeferredRevenue(), 17134000000L, 0.0);
        assertEquals(annualSheet.getCurrentDebt(), 14236000000L, 0.0);
        assertEquals(annualSheet.getShortTermDebt(), 7183000000L, 0.0);
        assertEquals(annualSheet.getTotalNonCurrentLiabilities(), 106679000000L, 0.0);
        assertEquals(annualSheet.getCapitalLeaseObligations(), 4931000000L, 0.0);
        assertEquals(annualSheet.getLongTermDebt(), 122995000000L, 0.0);
        assertEquals(annualSheet.getCurrentLongTermDebt(), 7053000000L, 0.0);
        assertEquals(annualSheet.getLongTermDebtNonCurrent(), 54355000000L, 0.0);
        assertEquals(annualSheet.getShortLongTermDebtTotal(), 130178000000L, 0.0);
        assertEquals(annualSheet.getOtherCurrentLiabilities(), 14190000000L, 0.0);
        assertEquals(annualSheet.getOtherNonCurrentLiabilities(), 14897000000L, 0.0);
        assertEquals(annualSheet.getTotalShareholderEquity(), 20597000000L, 0.0);
        assertEquals(annualSheet.getTreasuryStock(), 169339000000L, 0.0);
        assertEquals(annualSheet.getRetainedEarnings(), 162717000000L, 0.0);
        assertEquals(annualSheet.getCommonStock(), 56556000000L, 0.0);
        assertEquals(annualSheet.getCommonStockSharesOutstanding(), 892653424L, 0.0);

    }

    @Test
    public void testCompanyOverviewResponse() throws IOException {
        CompanyOverviewResponse response = CompanyOverviewResponse.of(json("companyoverview"));
        CompanyOverview overview = response.getOverview();
        assertNull(response.getErrorMessage());
        assertNotNull(response.toString());
        assertEquals(overview.getSymbol(), "IBM");
        assertEquals(overview.getAssetType(), "Common Stock");
        assertEquals(overview.getName(), "International Business Machines Corporation");
        assertEquals(overview.getDescription(), "International Business Machines Corporation (IBM) is an American multinational technology company headquartered in Armonk, New York, with operations in over 170 countries. The company began in 1911, founded in Endicott, New York, as the Computing-Tabulating-Recording Company (CTR) and was renamed International Business Machines in 1924. IBM is incorporated in New York. IBM produces and sells computer hardware, middleware and software, and provides hosting and consulting services in areas ranging from mainframe computers to nanotechnology. IBM is also a major research organization, holding the record for most annual U.S. patents generated by a business (as of 2020) for 28 consecutive years. Inventions by IBM include the automated teller machine (ATM), the floppy disk, the hard disk drive, the magnetic stripe card, the relational database, the SQL programming language, the UPC barcode, and dynamic random-access memory (DRAM). The IBM mainframe, exemplified by the System/360, was the dominant computing platform during the 1960s and 1970s.");
        assertEquals(overview.getCIK(), 51143L, 0.0);
        assertEquals(overview.getExchange(), "NYSE");
        assertEquals(overview.getCurrency(), "USD");
        assertEquals(overview.getCountry(), "USA");
        assertEquals(overview.getSector(), "TECHNOLOGY");
        assertEquals(overview.getIndustry(), "COMPUTER & OFFICE EQUIPMENT");
        assertEquals(overview.getAddress(), "1 NEW ORCHARD ROAD, ARMONK, NY, US");
        assertEquals(overview.getFiscalYearEnd(), "December");
        assertEquals(overview.getLatestQuarter(), "2021-09-30");
        assertEquals(overview.getMarketCapitalization(), 106626228000L, 0.0);
        assertEquals(overview.getEBITDA(), 15659000000L, 0.0);
        assertEquals(overview.getPERatio(), 22.52, 0.0);
        assertEquals(overview.getPEGRatio(), 2.057, 0.0);
        assertEquals(overview.getBookValue(), 24.79, 0.0);
        assertEquals(overview.getDividendPerShare(), 6.54, 0.0);
        assertEquals(overview.getDividendYield(), 0.0544, 0.0);
        assertEquals(overview.getEPS(), 5.28, 0.0);
        assertEquals(overview.getRevenuePerShareTTM(), 83.23, 0.0);
        assertEquals(overview.getProfitMargin(), 0.064, 0.0);
        assertEquals(overview.getOperatingMarginTTM(), 0.12, 0.0);
        assertEquals(overview.getReturnOnAssetsTTM(), 0.0374, 0.0);
        assertEquals(overview.getReturnOnEquityTTM(), 0.214, 0.0);
        assertEquals(overview.getRevenueTTM(), 74461004000L, 0.0);
        assertEquals(overview.getGrossProfitTTM(), 35575000000L, 0.0);
        assertEquals(overview.getDilutedEpsTTM(), 5.28, 0.0);
        assertEquals(overview.getQuarterlyEarningsGrowthYOY(), -0.338, 0.0);
        assertEquals(overview.getQuarterlyRevenueGrowthYOY(), 0.003, 0.0);
        assertEquals(overview.getAnalystTargetPrice(), 148.48, 0.0);
        assertEquals(overview.getTrailingPE(), 22.52, 0.0);
        assertEquals(overview.getForwardPE(), 10.37, 0.0);
        assertEquals(overview.getPriceToSaleRatioTTM(), 1.432, 0.0);
        assertEquals(overview.getPriceToBookRatio(), 4.852, 0.0);
        assertEquals(overview.getEvToRevenue(), 2.132, 0.0);
        assertEquals(overview.getEvToEBITDA(), 12.24, 0.0);
        assertEquals(overview.getBeta(), 1.102, 0.0);
        assertEquals(overview.getFiftyTwoWeekHigh(), 142.43, 0.0);
        assertEquals(overview.getFiftyTwoWeekLow(), 105.39, 0.0);
        assertEquals(overview.getFiftyDayMovingAverage(), 128.52, 0.0);
        assertEquals(overview.getTwoHundredDayMovingAverage(), 134.22, 0.0);
        assertEquals(overview.getSharesOutstanding(), 896320000L, 0.0);
        assertEquals(overview.getDividendDate(), "2021-12-10");
        assertEquals(overview.getExDividendDate(), "2021-11-09");

    }

    @Test
    public void testIncomeStatementResponse() throws IOException {
        IncomeStatementResponse response = IncomeStatementResponse.of(json("incomestatement"));
        assertEquals(response.getAnnualReports().size(), 2);
        assertEquals(response.getQuarterlyReports().size(), 3);
        assertNull(response.getErrorMessage());
        assertEquals(response.getSymbol(), "IBM");

        IncomeStatement incomeStatement = response.getAnnualReports().get(0);
        assertNotNull(incomeStatement.toString());

        assertEquals(incomeStatement.getFiscalDateEnding(), "2020-12-31");
        assertEquals(incomeStatement.getReportedCurrency(), "USD");
        assertEquals(incomeStatement.getGrossProfit(), 35575000000L, 0.0);
        assertEquals(incomeStatement.getTotalRevenue(), 73620000000L, 0.0);
        assertEquals(incomeStatement.getCostOfRevenue(), 38046000000L, 0.0);
        assertEquals(incomeStatement.getCostofGoodsAndServicesSold(), 439000000L, 0.0);
        assertEquals(incomeStatement.getOperatingIncome(), 4609000000L, 0.0);
        assertEquals(incomeStatement.getSellingGeneralAndAdministrative(), 23082000000L, 0.0);
        assertEquals(incomeStatement.getResearchAndDevelopment(), 6333000000L, 0.0);
        assertEquals(incomeStatement.getOperatingExpenses(), 30966000000L, 0.0);
        assertEquals(incomeStatement.getNetInterestIncome(), -1288000000L, 0.0);
        assertNull(incomeStatement.getInvestmentIncomeNet());
        assertEquals(incomeStatement.getInterestExpense(), 1288000000L, 0.0);
        assertEquals(incomeStatement.getInterestIncome(), 105000000L, 0.0);
        assertNull(incomeStatement.getNonInterestIncome());
        assertEquals(incomeStatement.getOtherNonOperatingIncome(), -861000000L, 0.0);
        assertEquals(incomeStatement.getDepreciation(), 4227000000L, 0.0);
        assertEquals(incomeStatement.getDepreciationAndAmortization(), 2468000000L, 0.0);
        assertEquals(incomeStatement.getIncomeBeforeTax(), 4726000000L, 0.0);
        assertEquals(incomeStatement.getIncomeTaxExpense(), -864000000L, 0.0);
        assertEquals(incomeStatement.getInterestAndDebtExpense(), 1288000000L, 0.0);
        assertEquals(incomeStatement.getNetIncomeFromContinuingOperations(), 5501000000L, 0.0);
        assertEquals(incomeStatement.getComprehensiveIncomeNetOfTax(), 4850000000L, 0.0);
        assertEquals(incomeStatement.getEbit(), 6014000000L, 0.0);
        assertEquals(incomeStatement.getEbitda(), 8482000000L, 0.0);
        assertEquals(incomeStatement.getNetIncome(), 5590000000L, 0.0);
    }

    @Test
    public void testEarningsResponse() throws IOException {
        EarningsResponse response = EarningsResponse.of(json("earnings"));
        assertEquals(response.getAnnualReports().size(), 2);
        assertEquals(response.getQuarterlyReports().size(), 3);
        assertNull(response.getErrorMessage());
        assertEquals(response.getSymbol(), "IBM");

        AnnualEarning annualEarning = response.getAnnualReports().get(0);
        assertNotNull(annualEarning.toString());
        assertEquals(annualEarning.getFiscalDateEnding(), "2020-12-31");
        assertEquals(annualEarning.getReportedEPS(), 8.67, 0.0);
        assertNull(response.getAnnualReports().get(1).getReportedEPS());

        QuarterlyEarning quarterlyEarning = response.getQuarterlyReports().get(0);
        assertNotNull(quarterlyEarning.toString());
        assertEquals(quarterlyEarning.getFiscalDateEnding(), "2020-09-30");
        assertEquals(quarterlyEarning.getReportedDate(), "2020-10-19");
        assertEquals(quarterlyEarning.getReportedEPS(), 2.58, 0.0);
        assertEquals(quarterlyEarning.getEstimatedEPS(), 2.579, 0.0);
        assertEquals(quarterlyEarning.getSurprise(), 0.001, 0.0);
        assertEquals(quarterlyEarning.getSurprisePercentage(), 0.0388, 0.0);

    }

    @Test
    public void testCashFlowResponse() throws IOException {
        CashFlowResponse response = CashFlowResponse.of(json("cashflow"));
        assertEquals(response.getAnnualReports().size(), 2);
        assertEquals(response.getQuarterlyReports().size(), 3);
        assertNull(response.getErrorMessage());
        assertEquals(response.getSymbol(), "IBM");

        CashFlow cashFlow = response.getAnnualReports().get(0);
        assertNotNull(cashFlow.toString());

        assertEquals(cashFlow.getFiscalDateEnding(), "2020-12-31");
        assertEquals(cashFlow.getReportedCurrency(), "USD");
        assertEquals(cashFlow.getOperatingCashflow(), 18197000000L, 0.0);
        assertEquals(cashFlow.getPaymentsForOperatingActivities(), 3406000000L, 0.0);
        assertNull(cashFlow.getProceedsFromOperatingActivities());
        assertEquals(cashFlow.getChangeInOperatingLiabilities(), 138000000L, 0.0);
        assertEquals(cashFlow.getChangeInOperatingAssets(), -5088000000L, 0.0);
        assertEquals(cashFlow.getDepreciationDepletionAndAmortization(), 6695000000L, 0.0);
        assertEquals(cashFlow.getCapitalExpenditures(), 2618000000L, 0.0);
        assertEquals(cashFlow.getChangeInReceivables(), -5297000000L, 0.0);
        assertEquals(cashFlow.getChangeInInventory(), 209000000L, 0.0);
        assertEquals(cashFlow.getProfitLoss(), 5590000000L, 0.0);
        assertEquals(cashFlow.getCashflowFromInvestment(), -3028000000L, 0.0);
        assertEquals(cashFlow.getCashflowFromFinancing(), -9721000000L, 0.0);
        assertEquals(cashFlow.getProceedsFromRepaymentsOfShortTermDebt(), -853000000L, 0.0);
        assertNull(cashFlow.getPaymentsForRepurchaseOfCommonStock());
        assertNull(cashFlow.getPaymentsForRepurchaseOfEquity());
        assertNull(cashFlow.getPaymentsForRepurchaseOfPreferredStock());
        assertEquals(cashFlow.getDividendPayout(), 5797000000L, 0.0);
        assertEquals(cashFlow.getDividendPayoutCommonStock(), 5797000000L, 0.0);
        assertNull(cashFlow.getDividendPayoutPreferredStock());

        assertEquals(cashFlow.getDividendPayout(), 5797000000L, 0.0);
        assertEquals(cashFlow.getDividendPayoutCommonStock(), 5797000000L, 0.0);
        assertNull(cashFlow.getDividendPayoutPreferredStock());
        assertNull(cashFlow.getProceedsFromIssuanceOfCommonStock());
        assertEquals(cashFlow.getProceedsFromIssuanceOfLongTermDebtAndCapitalSecuritiesNet(), 10504000000L, 0.0);
        assertNull(cashFlow.getProceedsFromIssuanceOfPreferredStock());

        assertEquals(cashFlow.getProceedsFromRepurchaseOfEquity(), -302000000L, 0.0);
        assertNull(cashFlow.getProceedsFromSaleOfTreasuryStock());
        assertEquals(cashFlow.getChangeInCashAndCashEquivalents(), 5448000000L, 0.0);
        assertNull(cashFlow.getChangeInExchangeRate());
        assertEquals(cashFlow.getNetIncome(), 5590000000L, 0.0);

    }

    @Test
    public void testEmptyCompanyOverviewResponse() throws IOException {
        CompanyOverviewResponse response = CompanyOverviewResponse.of(empty());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testEmptyBalanceSheetResponse() throws IOException {
        BalanceSheetResponse response = BalanceSheetResponse.of(empty());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testEmptyCashFlowResponse() throws IOException {
        CashFlowResponse response = CashFlowResponse.of(empty());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testEmptyEarningsResponse() throws IOException {
        EarningsResponse response = EarningsResponse.of(empty());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testEmptyIncomeStatementResponse() throws IOException {
        IncomeStatementResponse response = IncomeStatementResponse.of(empty());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testErrorCompanyOverviewResponse() throws IOException {
        CompanyOverviewResponse response = CompanyOverviewResponse.of(error());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testErrorBalanceSheetResponse() throws IOException {
        BalanceSheetResponse response = BalanceSheetResponse.of(error());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testErrorCashFlowResponse() throws IOException {
        CashFlowResponse response = CashFlowResponse.of(error());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testErrorEarningsResponse() throws IOException {
        EarningsResponse response = EarningsResponse.of(error());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

    @Test
    public void testErrorIncomeStatementResponse() throws IOException {
        IncomeStatementResponse response = IncomeStatementResponse.of(error());
        assertNotNull(response.toString());
        assertNotNull(response.getErrorMessage());
    }

}