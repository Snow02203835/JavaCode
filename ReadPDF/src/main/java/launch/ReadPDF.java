package launch;

import expense.Expense;
import expense.Item;
import log.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadPDF {
    public static String getData(String path) {
        try {
            File pdfFolder = new File(path);
            File[] files = pdfFolder.listFiles();
            if (files == null) {
                return "文件夹中不存在文件";
            }
            List<Item> items = new ArrayList<>();
            for(File file : files) {
                try {
                    if (file.getName().contains(".pdf")) {
                        Logger.log("read pdf file: " + file.getAbsolutePath());
                        items.add(readText(transferPdfToText(file)));
                    }
                } catch (Exception e) {
                    Logger.log(e.getLocalizedMessage());
                }
            }
            return writeExcel(path, items);
        } catch(Exception e) {
            Logger.log(e.getLocalizedMessage());
        }
        return "识别出错";
    }

    private static Item readText(String textPath) {
        Item item = null;
        try {
            File text = new File(textPath);
            FileInputStream inputStream = new FileInputStream(text);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            if ((line = reader.readLine()) != null) {
                Expense expense = ExpenseFactory.getExpense(line);
                item = expense.getInfo(reader);
            }
            reader.close();
            inputStream.close();
            boolean result = text.delete();
            Logger.log("delete " + text.getName() + " = " + result);
        } catch (Exception exception) {
            Logger.log(exception.getLocalizedMessage());
        }
        return item;
    }

    private static String transferPdfToText(File pdf) {
        try {
            PDDocument doc = PDDocument.load(pdf);
            int pageNum = doc.getNumberOfPages();
            String outputFileName = "./temp_" + System.currentTimeMillis() + ".txt";
            FileOutputStream fos = new FileOutputStream(outputFileName);
            Writer writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setStartPage(0);
            stripper.setEndPage(pageNum);
            stripper.writeText(doc, writer);
            writer.close();
            doc.close();
            return outputFileName;
        } catch (Exception exception) {
            Logger.log(exception.getLocalizedMessage());
        }
        return null;
    }

    public static String writeExcel(String path, List<Item> items) {
        try {
            String excelPath =  path + "\\result" + ".csv";
            FileOutputStream outputStream = new FileOutputStream(excelPath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write("HRO,姓名,工号,出差费用报销（WBBX）,交通费,住宿费,餐费,差旅费,打印费,团建费,特殊交通费,自驾费,快递费,日常费,费用总额,出发地,目的地,开始日期,结束日期,出差天数,备注\n");
            for (Item item : items) {
//                item.selfCheck();
                writer.write(builder(item));
            }
            writer.flush();
            writer.close();
            outputStream.close();
            return excelPath;
        } catch (Exception e) {
            Logger.log(e.getLocalizedMessage());
        }
        return "识别出错";
    }

    private static String builder(Item item) {
        if (item == null) {
            return "\n";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("仁联,");
        builder.append(item.getName()).append(',');
        builder.append(item.getWorkerNum()).append(',');
        builder.append(item.getOrderSN()).append(',');
        zeroAppend(builder, item.getTraffic());
        zeroAppend(builder, item.getAccommodation());
        zeroAppend(builder, item.getMeal());
        zeroAppend(builder, item.getTravel());
        zeroAppend(builder, item.getPrint());
        zeroAppend(builder, item.getTeam());
        zeroAppend(builder, item.getSpecialTraffic());
        zeroAppend(builder, item.getSelfDrive());
        zeroAppend(builder, item.getExpress());
        zeroAppend(builder, item.getDaily());
        zeroAppend(builder, item.getTotal());
        builder.append(",,").append(item.getStartDate()).append(',');
        builder.append(item.getEndDate()).append(',');
        zeroAppend(builder, item.countOutDays());
        builder.append(item.getComment() == null ? "" : item.getComment()).append('\n');
        return builder.toString();
    }

    private static void zeroAppend(StringBuilder builder, double num) {
        if (num == 0f) {
            builder.append(0).append(',');
        } else {
            builder.append(num).append(',');
        }
    }
}
