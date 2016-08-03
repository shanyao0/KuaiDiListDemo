package shanyao.kuaidilistdemo;

import java.util.ArrayList;

/**
 * Created by zs on 2016/8/3.
 */
public class DaoUtils {
    public static ArrayList<ConsultationBean> getList() {
        ArrayList<ConsultationBean> list = new ArrayList<>();
        ConsultationBean bean1 = new ConsultationBean();
        bean1.setPeople("华佗申请了会诊");
        bean1.setTime("2016-06-12 12:00");
        list.add(bean1);
        ConsultationBean bean2 = new ConsultationBean();
        bean2.setPeople("扁鹊需要华佗补充患者材料");
        bean2.setTime("2016-06-12 12:00");
        bean2.setMessage("扁鹊留言：患者的检查单需要补充");
        list.add(bean2);
        ConsultationBean bean3 = new ConsultationBean();
        bean3.setPeople("华佗申请了会诊");
        bean3.setTime("2016-06-12 12:00");
        list.add(bean3);
        ConsultationBean bean4 = new ConsultationBean();
        bean4.setPeople("待扁鹊提交会诊报告");
        list.add(bean4);
        return list;
    }
}
