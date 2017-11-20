package report;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import subreport.BeanFactory;
import subreport.SampleContents;

public class PrintMain {

  public static void main(String[] args) {

    try {
      System.out.println("start");
      //      String layoutFilePath = "layout\\jasper_test.jasper";
      String layoutFilePath = "layout\\test_sub1.jasper";

      //      dataの準備
      Map<String, Object> parameters = createMapData();
      List<SampleContents> list = BeanFactory.createListData();

      JasperPrint print = JasperFillManager.fillReport(layoutFilePath, parameters,
          new JRBeanCollectionDataSource(list));
      System.out.println("end fill");
      File exportFile = new File("sample.pdf");
      String exportFilePath = exportFile.getAbsolutePath();

      JasperExportManager.exportReportToPdfFile(print, exportFilePath);

      System.out.println("end export");
    } catch (JRException e) {
      e.printStackTrace();
    }

  }

  private static Map<String, Object> createMapData() {
    Map<String, Object> map = new HashMap<>();
    map.put("test", "テスト");
    return map;
  }

}
