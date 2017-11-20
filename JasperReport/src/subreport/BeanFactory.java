package subreport;

import java.util.ArrayList;
import java.util.List;

public class BeanFactory {

  public static List<SampleContents> createListData() {
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

}
