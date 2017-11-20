package subreport;

import java.util.ArrayList;
import java.util.List;

public class BeanFactory {

  public static List<Object> createBlankList() {
    List<Object> list = new ArrayList<>();
    list.add(new Object());
    return list;
  }

  public static List<SampleContents> createBlankSampleList() {
    List<SampleContents> list = new ArrayList<>();
    return list;
  }

  public static List<SampleContents> createList1Data() {
    List<SampleContents> list = new ArrayList<>();
    list.add(new SampleContents("りんご", "産地を明記してください。", "承知しました。", "10", "30"));
    list.add(new SampleContents("オレンジ", "産地を明記してください。", "承知しました。", "10", "30"));
    list.add(new SampleContents("ぶどう", "産地を明記してください。", "承知しました。", "10", "30"));
    list.add(new SampleContents("みかん1", "次は\"\"", "次は\"\"", "20", "50"));
    list.add(new SampleContents("みかん2", "", "", "20", "50"));
    list.add(new SampleContents("ばなな1", "次はnull", "次はnull", "20", "50"));
    list.add(new SampleContents("ばなな2", null, null, "20", "50"));
    list.add(new SampleContents("項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。", "産地を明記してください。", "承知しました。", "20",
        "50"));
    list.add(new SampleContents("パイン",
        "項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。",
        "承知しました。", "20", "50"));
    list.add(new SampleContents("もも", "産地を明記してください。", "承知しました。", "項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。",
        "30"));
    list.add(new SampleContents("メロン", "産地を明記してください。", "承知しました。", "10",
        "項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。"));
    return list;
  }

  public static Object createList2Data() {
    List<SampleContents> list = new ArrayList<>();
    list.add(new SampleContents("じゃがいも", "産地を明記してください。", "承知しました。", "10", "30"));
    list.add(new SampleContents("さつまいも", "産地を明記してください。", "承知しました。", "10", "30"));
    list.add(new SampleContents("里芋", "産地を明記してください。", "承知しました。", "10", "30"));
    list.add(new SampleContents("ピーマン1", "次は\"\"", "次は\"\"", "20", "50"));
    list.add(new SampleContents("ピーマン2", "", "", "20", "50"));
    list.add(new SampleContents("パプリカ1", "次はnull", "次はnull", "20", "50"));
    list.add(new SampleContents("パプリカ2", null, null, "20", "50"));
    list.add(new SampleContents("項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。", "産地を明記してください。", "承知しました。", "20",
        "50"));
    list.add(new SampleContents("トマト",
        "項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。",
        "承知しました。", "20", "50"));
    list.add(
        new SampleContents("きゅうり", "産地を明記してください。", "承知しました。", "項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。",
            "30"));
    list.add(new SampleContents("なす", "産地を明記してください。", "承知しました。", "10",
        "項目が長い場合のテスト用です。これはダミー文章です。項目が長い場合のテスト用です。これはダミー文章です。"));
    //    list.add(new SampleContents("アスパラガス", "産地を明記してください。", "承知しました。", "10", "30"));
    //    list.add(new SampleContents("ブロッコリー", "産地を明記してください。", "承知しました。", "10", "30"));
    return list;
  }

}
