package report;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import subreport.BeanFactory;

public class PrintMain {

  public static void main(String[] args) {

    String layoutFilePath = "layout\\jasper_test.jasper";
    //      String layoutFilePath = "layout\\test_sub1.jasper";
    System.out.println("start: " + layoutFilePath);
    try {

      //      dataの準備
      Map<String, Object> parameters = createMapData();

      JasperPrint print = JasperFillManager.fillReport(layoutFilePath, parameters,
          new JRBeanCollectionDataSource(BeanFactory.createBlankList()));
      System.out.println("end fill");
      File exportFile = new File("sample.pdf");
      String exportFilePath = exportFile.getAbsolutePath();

      JasperExportManager.exportReportToPdfFile(print, exportFilePath);

      System.out.println("end export: " + exportFilePath);
    } catch (JRException e) {
      e.printStackTrace();
    }

  }

  private static Map<String, Object> createMapData() {
    Map<String, Object> map = new HashMap<>();
    map.put("listSub1", BeanFactory.createList1Data());
    map.put("listSub2", BeanFactory.createList2Data());
    map.put("listSub3", BeanFactory.createBlankSampleList());
    return map;
  }

}
