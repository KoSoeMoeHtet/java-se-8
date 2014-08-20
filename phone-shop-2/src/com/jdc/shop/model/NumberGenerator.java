package com.jdc.shop.model;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

import com.jdc.shop.ShopAppException;


public class NumberGenerator {
	// number format (yyyyMMdd0000)
	private Optional<String> lastNumber;
	private int counter;
	private static String DF = "yyyyMMdd";

	Function<Optional<String>, String> dateFunction = (e) -> {
		if (null != e && e.orElse("").length() == 12) {
			return e.get().substring(0, 8);
		}
		return e.orElse(null);
	};

	Function<Optional<String>, Integer> countFunction = (e) -> {
		if (null != e && e.orElse("").length() == 12) {
			return Integer.parseInt(e.get().substring(8));
		}
		return 0;
	};

	public NumberGenerator(Optional<String> lastNumber) {
		this.lastNumber = lastNumber;
		this.counter = countFunction.apply(lastNumber);
	}

	public String getNumber() {
		
		// get date from last number
		String date = dateFunction.apply(lastNumber);

		// if last date eq today ->counter ++
		DateFormat df = new SimpleDateFormat(DF);
		String today = df.format(new Date());
		if (today.equals(date)) {
			counter++;
		} else {
			// else counter set 1
			counter = 1;
		}

		// generate number
		lastNumber = Optional.of(String.format("%s%s", today,
				new DecimalFormat("0000").format(counter)));

		return lastNumber.orElseThrow(() -> new ShopAppException(
				"System Error"));
	}

}
