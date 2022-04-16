package com.pontons.spring.webflux.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Table;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className DocumentPdf
 * @description TODO
 * @date 2022/2/9
 */
public class DocumentPdf {

    public void gene() throws Exception {
        //创建文档，设置页面格式为A4纸
        Document document = new Document(PageSize.A4, 10, 10, 10, 10);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream
                (new File("D:/test.pdf")));
        //开启文档
        document.open();
        //设置字体
        BaseFont baseFont = BaseFont.createFont();
        Font font1 = new Font(baseFont, 12, Font.NORMAL);
        PdfPTable table = new PdfPTable(4);

        //设置控制
        table.setSpacingBefore(70);//表格前间距
        table.setSpacingAfter(70);//表格后间距
        table.setWidthPercentage(75);//表格宽占page比例
        table.setHorizontalAlignment(Element.ALIGN_CENTER);//表格水平对齐方式
        /*
         *      设置构成标题的顶部行数。只有当表被添加到文档并且表跨页时，这个header才有意义。
         */

        table.setHeaderRows(1);
        /*
         *     设置页脚要使用的行数。页脚的数量从页眉行中减去。例如，对于一个有两个页眉行和一个页脚行的表，代码应该是:
         *    table.setHeaderRows (3);
         *    table.setFooterRows (1);
         *    第0行和第1行是页眉行，第2行是页脚行。
         */
        //table.setFooterRows(1);
        table.setPaddingTop(10f);//设置表格顶部padding
        //设置单元格
        /**
         * getDefaultCell()得到的Cell代表所有不是table.add(PdfPCell)的Cell。例：table.add(new Paragraph("test")).
         */
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);//单元格中文字垂直对齐方式
        table.getDefaultCell().setBorderColor(new BaseColor(0,0,255));//单元格线条颜色
        table.getDefaultCell().setMinimumHeight(30);//单元格最小高度
        table.getDefaultCell().setExtraParagraphSpace(5);//段落文字与表格之间的距离,底部距离
        table.getDefaultCell().setLeading(15, 0);//设置行间距
//        table.getDefaultCell().setFixedHeight(20f);//表格固定高度

        table.addCell(new Paragraph("name"));
        table.addCell(new Paragraph("age"));
        table.addCell(new Paragraph("addr"));
        table.addCell(new Paragraph("salary"));
        for (int i = 0; i < 320*4; i++) {
            table.addCell(new Paragraph("test"+i));
        }
        document.add(table);
        document.close();


    }

    public void testTable2() {

    }




    public static void main(String[] args) throws Exception {
        new DocumentPdf().gene();
    }
}
