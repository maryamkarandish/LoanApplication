package com.example.zopa;

import com.example.zopa.QuoteException.QuoteException;
import com.example.zopa.QuoteException.QuoteExceptionMessages;
import com.example.zopa.model.Lender;
import com.example.zopa.model.Quote;
import com.example.zopa.service.LoanService;
import com.example.zopa.utils.CommandUtils;
import com.example.zopa.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class LoanApplication {

	public static void main(String[] args) throws FileNotFoundException, QuoteException {

		if (args.length > 0) {
			File inFile = new File(args[0]);
			List<Lender> lendersList = FileUtils.getCsvFileAsList(inFile);
			LoanService loanService = new LoanService();

			if (args.length > 1) {

				Quote result = new Quote();
				result.setRequestAmount(CommandUtils.getLoanAmountInput(args[1]));

				result = loanService.getRateAndRepayments(lendersList, result);

				CommandUtils.printExitStatus(result);
			} else {
				throw new QuoteException(QuoteExceptionMessages.INCORRECT_ARGUMENTS);
			}
		} else {
			throw new QuoteException(QuoteExceptionMessages.INCORRECT_ARGUMENTS);
		}
	}

}
