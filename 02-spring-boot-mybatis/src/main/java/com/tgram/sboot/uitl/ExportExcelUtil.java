package com.tgram.sboot.uitl;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *<p> Description: 导出Excel工具类 </p>
 *<p> Copyright: Copyright(c) 2018/12/27 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/27 11:30
 */
public class ExportExcelUtil
{
    
    public static void exportExcel(List<List<String>> dataList, OutputStream stream, boolean isNewVersion)
    {
        if (dataList == null || dataList.size() == 0)
        {
            return;
        }
        
        // 1.创建Workbook对象(excel的文档对象)
        Workbook workbook;
        if (isNewVersion)
        {
            workbook = new SXSSFWorkbook();
        }
        else
        {
            workbook = new HSSFWorkbook();
        }
        
        // 2.创建文档格式对象并建立新的sheet对象（excel的表单）
        CellStyle cellStyle = getCellStyle(workbook);
        Sheet sheet = workbook.createSheet();
        
        // 3.创建行对象,循环生成数据
        Row row;
        List<String> list;
        for (int i = 0; i < dataList.size(); i++)
        {
            // 循环遍历生成每一行数据,list保存每行对应的列数据
            row = sheet.createRow(i);
            list = dataList.get(i);
            for (int j = 0; j < list.size(); j++) {
                Cell cell = row.createCell(j);      // 通过行对象创建列对象
                cell.setCellValue(list.get(j));     // 设置列数据
                cell.setCellStyle(cellStyle);       // 设置列样式
            }
        }

        try {
            // 4.通过输出流写入数据到Excel文档对象中
            workbook.write(stream);
        } catch (IOException e) {
            throw new RuntimeException("系统内部错误");
        }

    }
    
    /**
     * 设置Excel的格式
     * @param workbook Workbook文档对象
     * @return CellStyle对象
     */
    private static CellStyle getCellStyle(Workbook workbook)
    {
        CellStyle cellStyle = workbook.createCellStyle();
        DataFormat dataFormat = workbook.createDataFormat();
        //文本类型
        cellStyle.setDataFormat(dataFormat.getFormat("@"));
        //自动换行
        cellStyle.setWrapText(true);
        //上下居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        
        return cellStyle;
    }
}
