package com.example.zopa;

import com.example.zopa.QuoteException.QuoteException;
import com.example.zopa.model.Lender;
import com.example.zopa.model.Quote;
import com.example.zopa.service.LoanService;
import com.example.zopa.utils.CommandUtils;
import com.example.zopa.utils.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LoanApplicationTests {

	private  LoanService loanService;
	private  List<Lender> lenders = new ArrayList<>();
	private  int loanAmount;
	private  Quote quoteResult;
	private FileUtils fileUtils = new FileUtils();
	private CommandUtils commandUtils = new CommandUtils();

	@Before
	public  void init() {

		lenders.add(new Lender("Jane", BigDecimal.valueOf(0.069), 480));
		lenders.add(new Lender("Mary", BigDecimal.valueOf(0.104), 170));
		lenders.add(new Lender("Angela", BigDecimal.valueOf(0.071), 60));
		lenders.add(new Lender("Fred", BigDecimal.valueOf(0.071), 520));

		loanAmount = 1000;

		loanService = new LoanService();
		quoteResult = new Quote();
		quoteResult.setRequestAmount(loanAmount);
	}

	/**
	 * @throws
	 */
	@Test
	@Category(PositiveCategoryTest.class)
//	@Ignore
	public void qouteTotalRepaymentTest() throws QuoteException
	{
		this.loanService.getRateAndRepayments(lenders,quoteResult);
		assertEquals(1108.10, quoteResult.getTotalPayment());
		System.out.println("--------------");
	}

	@Test
	@Category(PositiveCategoryTest.class)
	public void quotePercentageRateTest() throws QuoteException {
		this.loanService.getRateAndRepayments(lenders,quoteResult);
		assertEquals(7.0d,quoteResult.getPercentageRate());
		System.out.println("--------------");
	}

	@Test
	@Category(PositiveCategoryTest.class)
	public void getMonthlyPaymentTest() throws QuoteException {
		this.loanService.getRateAndRepayments(lenders,quoteResult);
		assertEquals(30.78,quoteResult.getMonthlyPayment());
		System.out.println("--------------");
	}

	@Test(expected = QuoteException.class)
	@Category(NegativeCategoryTest.class)
	public void getNegativeAmountFromFileTest() throws QuoteException {
		lenders.get(0).setAvailableAmount(-10);
		fileUtils.validateFileData(lenders.get(0));
		System.out.println("--------------");

	}


	@Test(expected = QuoteException.class)
	@Category(NegativeCategoryTest.class)
	public void getNegativeRateFromFileTest() throws QuoteException {
		lenders.get(0).setRate(new BigDecimal(-10));
		fileUtils.validateFileData(lenders.get(0));
		System.out.println("--------------");
	}

	@Test(expected = QuoteException.class)
	@Category(NegativeCategoryTest.class)
	public void getEmptyLenderName() throws QuoteException {
		lenders.get(0).setLenderName("");
		fileUtils.validateFileData(lenders.get(0));
		System.out.println("--------------");
	}

	@Test(expected = QuoteException.class)
	@Category(NegativeCategoryTest.class)
	public void validateRequestedAmountTest() throws QuoteException {
		String invalidLaonAmount = "-1000";
		commandUtils.getLoanAmountInput(invalidLaonAmount);
		System.out.println("--------------");
	}

	@Test(expected = QuoteException.class)
	@Category(NegativeCategoryTest.class)
	public void validateRequestedAmountRangeTest() throws QuoteException {
		String invalidLaonAmount = "200000";
		commandUtils.getLoanAmountInput(invalidLaonAmount);
		System.out.println("--------------");
	}

	@Test(expected = QuoteException.class)
	@Category(NegativeCategoryTest.class)
	public void validateRequestedAmountRatioTest() throws QuoteException {
		String invalidLaonAmount = "6251";
		commandUtils.getLoanAmountInput(invalidLaonAmount);
		System.out.println("--------------");
	}

	@Test(expected = QuoteException.class)
	@Category(NegativeCategoryTest.class)
	public void validateLoanAmountGreaterThanPoolBalance() throws QuoteException {
		double invalidLaonAmount = 2500.0;
		loanService.validateBalance(lenders,invalidLaonAmount);
		System.out.println("--------------");
	}

	@Test
	@Category(PositiveCategoryTest.class)
	public void getvalidRequestAmount() throws QuoteException {
		commandUtils.getLoanAmountInput("2000");
		System.out.println("--------------");
	}
	@AfterClass
	public static void endOfTest(){
		System.out.println("All LoanApplication's Tests Passed Successfully !");
	}

}
