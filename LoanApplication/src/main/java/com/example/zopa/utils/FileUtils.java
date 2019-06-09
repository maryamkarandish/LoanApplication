package com.example.zopa.utils;

import com.example.zopa.QuoteException.QuoteException;
import com.example.zopa.QuoteException.QuoteExceptionMessages;
import com.example.zopa.model.Lender;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by m.karandish on 6/8/2019.
 */
public class FileUtils {
    public static List<Lender> getCsvFileAsList(final File csvFile) throws FileNotFoundException, QuoteException{

        List<Lender> returnList = new ArrayList<>();

        if (!FilenameUtils.getExtension(csvFile.getName()).equals("csv")){
            throw new QuoteException(QuoteExceptionMessages.INCORRECT_FILE_EXTENSION);
        } else {
            Scanner scanner = new Scanner(csvFile);

            String line = scanner.nextLine();;
            String[] fields;
            Lender lender;

            while(scanner.hasNextLine()){

                line = scanner.nextLine();
                fields = line.split(",");

                // At least one address specified.
                if (fields.length == 3) {
                    lender = new Lender(fields[0], new BigDecimal(fields[1]), Integer.parseInt(fields[2]));
                    if(validateFileData(lender)){
                        returnList.add(lender);

                    }
                } else {
                    scanner.close();
                    throw new QuoteException(QuoteExceptionMessages.INCORRECT_FORMAT_FILE);
                }
            }
            scanner.close();
        }
        return returnList;
    }

    public static boolean validateFileData(Lender lender) throws QuoteException {
        if(lender.getAvailableAmount()<= 0){
            throw new QuoteException(QuoteExceptionMessages.INCORRECT_AMOUNT);
        }
        if(lender.getRate().doubleValue()<= 0){
            throw new QuoteException(QuoteExceptionMessages.INCORRECT_RATE_FORMAT);
        }
        if(lender.getLenderName().equalsIgnoreCase("")){
            throw new QuoteException(QuoteExceptionMessages.INCORRECT_NAME);
        }
        return true;
    }
}
