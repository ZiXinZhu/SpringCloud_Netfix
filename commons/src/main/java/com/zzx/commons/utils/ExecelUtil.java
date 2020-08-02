package com.zzx.commons.utils;


import com.zzx.commons.exceptions.CommonException;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;

public class ExecelUtil {

    private static Logger logger = LoggerFactory.getLogger("info");

    /**
     * ����execel��ģ��
     */
    public static void download(HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();//����Excel�ļ�(Workbook)
        HSSFSheet sheet = workbook.createSheet("sheet1");//����������(Sheet)
//���õ�һ�п�3766��
        sheet.setColumnWidth(0, 3766);
        HSSFRow row = sheet.createRow(0);// ������,��0��ʼ
        for (int i = 0; i < 10; i++) {
            HSSFCell cells = row.createCell(i);// ���õ�Ԫ������,����
            styleOne(workbook, cells).setCellValue("��" + i + "������");
        }
        HSSFRow row_one = sheet.createRow(1);
        HSSFCell cell = row_one.createCell(0);
        styleTwo(workbook, cell).setCellValue(131231688);//���õ�Ԫ���ʽΪ"�ı�"
        row_one.createCell(1).setCellValue("������2��");
        row_one.createCell(2).setCellValue("������3��");
        row_one.createCell(3).setCellValue("������4��");
        row_one.createCell(4).setCellValue("������5��");


        OutputStream outputStream = null;
        String filename = "ģ��.xls";
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
            outputStream = response.getOutputStream();
            workbook.write(outputStream);//����Excel�ļ�
            if (outputStream != null) {
                outputStream.close();//�ر��ļ���
            }
        } catch (Exception e) {
            logger.info("execel�����ʱ����,�������飺{}", e.getMessage());
            throw new CommonException("execel�����ʱ����");
        }
        System.out.println("OK!");
    }


    /**
     * �ϴ�������execel��
     *
     * @param file
     * @return
     * @throws IOException
     * @throws FileUploadException
     */
    public static String upLoadExecel(MultipartFile file) {

        byte[] b = new byte[0];
        try {
            b = file.getBytes();
        } catch (IOException e) {
            logger.info("�ϴ��ļ�����,�������飺{}", e.getMessage());
            throw new CommonException("�ϴ��ļ�����");
        }
        InputStream is = new ByteArrayInputStream(b);
        HSSFWorkbook hssfWorkbook = null;
        try {
            hssfWorkbook = new HSSFWorkbook(is);
        } catch (IOException e) {
            logger.info("���ļ�Ϊ��execel�ļ�,�������飺{}", e.getMessage());
            throw new CommonException("���ļ�Ϊ��execel�ļ�");
        }
        // ѭ��������Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // ѭ����Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                // ѭ����Cell
                for (int j = 0; j <= hssfRow.getLastCellNum(); j++) {
                    HSSFCell cell = hssfRow.getCell(j);
                    if (cell == null) {
                        continue;
                    }
                    System.out.println(getCellDate(cell));
                }
            }
        }
        return "�����ϴ��ɹ���";
    }


    /**
     * ������ȡ��Ӧ����ֵ��̬������
     *
     * @param cell
     * @return
     */
    private static String getCellDate(Cell cell) {

        String return_string = null;
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                return_string = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                DecimalFormat format = new DecimalFormat("#,##0.000");
                return_string = String.valueOf(format.format(cell.getNumericCellValue()));
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                return_string = String.valueOf(cell.getBooleanCellValue());
            default:
                return_string = "";
                break;
        }
        return return_string;
    }


    /**
     * ��ȡexecel����ı�����
     *
     * @param file
     * @throws IOException
     */
    public static void outText(MultipartFile file) throws IOException {
        byte[] b = new byte[0];
        try {
            b = file.getBytes();
        } catch (IOException e) {
            logger.info("�ϴ��ļ�����,�������飺{}", e.getMessage());
            throw new CommonException("�ϴ��ļ�����");
        }
        InputStream in = new ByteArrayInputStream(b);
        //(����ֱ��ʹ�õ���������ǽӿڣ���Ϊ����ʵ�ֻ����Լ��ķ���������ǿ��)
        POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = new HSSFWorkbook(fs);

        ExcelExtractor excelExtractor = new ExcelExtractor(wb);
        //ȥ��sheet����
        excelExtractor.setIncludeSheetNames(false);
        //��ȡ�ı����
        System.out.println(excelExtractor.getText());
        in.close();
    }


    /**
     * ��ʽ1
     *
     * @param workbook
     * @param cell
     * @return
     */
    private static HSSFCell styleOne(HSSFWorkbook workbook, HSSFCell cell) {
        //����CellStyle��HSSFCellStyle����
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

//���õ�Ԫ������λ��ˮƽ����
        style.setAlignment(HorizontalAlignment.LEFT);
//���õ�Ԫ������λ�ô�ֱ����
        style.setVerticalAlignment(VerticalAlignment.CENTER);
//���ñ߿�
        style.setBorderBottom(BorderStyle.THIN);   //�ײ��߿���ʽ
        //ͨ����ɫ�������õײ���ɫ
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex()); //�ײ��߿���ɫ

        //ͬ�����������ʽ
        style.setBorderLeft(BorderStyle.THIN);    //��߱߿���ʽ
        style.setLeftBorderColor(IndexedColors.BLUE.getIndex());    //��߱߿���ɫ

        //ͬ�������ұ���ʽ
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.GREEN.getIndex());
        //������ö�����ʽ
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BROWN.getIndex());
//��������
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 12); // ����߶�
        font.setFontName(" ���� "); // ����
        style.setFont(font);
        cell.setCellStyle(style);
        return cell;
    }

    /**
     * ��ʽ2
     *
     * @param workbook
     * @param cell
     * @return
     */
    private static HSSFCell styleTwo(HSSFWorkbook workbook, HSSFCell cell) {
        //���õ�Ԫ�����ݸ�ʽ
        HSSFCellStyle textStyle = workbook.createCellStyle();
        HSSFDataFormat format = workbook.createDataFormat();
        textStyle.setDataFormat(format.getFormat("#,##0.000"));
        cell.setCellStyle(textStyle);
        return cell;
    }

}
