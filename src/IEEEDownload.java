import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class IEEEDownload {
	public void download(String[] sup, String path) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sample sheet");
		int rownum = 0;
		for (int i = 1; i <= sup.length; i++) {
			if(sup[i-1] == null)
					break;
			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			Object obj = i;
			Cell cell = row.createCell(cellnum);
			if (obj instanceof Integer)
				cell.setCellValue((Integer) obj);
			else if (obj instanceof String)
				cell.setCellValue((String) obj);
			else if (obj instanceof Double)
				cell.setCellValue((Double) obj);
			cellnum++;
			obj = sup[i-1];
			cell = row.createCell(cellnum);
			if (obj instanceof Integer)
				cell.setCellValue((Integer) obj);
			else if (obj instanceof String)
				cell.setCellValue((String) obj);
			else if (obj instanceof Double)
				cell.setCellValue((Double) obj);
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
