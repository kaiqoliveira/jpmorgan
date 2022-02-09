package br.com.api.restapi.services;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.restapi.model.Trade;
import br.com.api.restapi.model.dto.CsvDTO;

@Service
public class CreateCsvService {

	@Autowired
	private FetchDataService dbService;

	public String createCsv() {

		List<CsvDTO> csv = new ArrayList<CsvDTO>();
		List<Trade> trades = new ArrayList<Trade>();
		trades.addAll(dbService.findAllTrades());
		for (Trade t : trades) {
			CsvDTO dto = new CsvDTO();
			dto.setTraderCode(t.getOrderid().getTrader().getTraderCode());
			dto.setTraderName(t.getOrderid().getTrader().getTraderName());
			dto.setOrderId(t.getOrderid().getOrderid());
			dto.setTicker(t.getOrderid().getTicker());
			dto.setQuantity(t.getQuantity());
			dto.setPrice(BigDecimal.valueOf(t.getPrice()));
			csv.add(dto);
		}

		String diretorio = this.createFile(csv);

		return diretorio;
	}

	private String createFile(List<CsvDTO> csv) {
		try {
			String nomeArquivo = "teste";
			String diretorio = "C:\\temp\\teste22.csv";
			FileWriter fw = new FileWriter(diretorio);
			fw.append("TraderCode, TraderName, OrderID, Ticker, Quantity, Price");
			for (CsvDTO c : csv) {

				fw.append("\n");
				fw.append(c.getTraderCode());
				fw.append(", ");
				fw.append(c.getTraderName());
				fw.append(", ");
				fw.append(c.getOrderId().toString());
				fw.append(", ");
				fw.append(c.getTicker());
				fw.append(", ");
				fw.append(c.getQuantity().toString());
				fw.append(", ");
				fw.append(c.getPrice().toString());

			}

			fw.flush();
			fw.close();
			System.out.println("CSV File is created successfully.");
			return diretorio;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
