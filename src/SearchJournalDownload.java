import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class SearchJournalDownload {
	public void Download(Object[][] values2, String columns[],String path,boolean[] DownloadCri) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sample sheet");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();
		int record = 1;
		data.put(1, columns);
		System.out.println("download " + values2.length);
		for(int i=0;i<values2.length;i++){
			data.put(i+2, values2[i]);
			record++;
		}
		int rownum = 0;
		for (int i = 1; i <= record; i++) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(i);
			int cellnum = -1;
			int continuefind = 0;
			for (Object obj : objArr) {
				cellnum++;
				if(!DownloadCri[cellnum]){
					continuefind++;
					continue;
				}
				Cell cell = row.createCell(cellnum-continuefind);
				if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}

		try {
			// new excel file created by fileoutput stream object
			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
