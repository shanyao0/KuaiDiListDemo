package shanyao.kuaidilistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ConsultationBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        list = DaoUtils.getList();
        listView.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(MainActivity.this, R.layout.item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            ConsultationBean bean = list.get(position);
            holder.tvPeople.setText(bean.getPeople());
            holder.tvTime.setText(bean.getTime());
            holder.tvTime.setVisibility(TextUtils.isEmpty(bean.getTime()) ? View.GONE : View.VISIBLE);
            holder.tvMessage.setText(bean.getMessage());
            holder.tvMessage.setVisibility(TextUtils.isEmpty(bean.getMessage()) ? View.GONE : View.VISIBLE);
            holder.tvPeople.setSelected(position == list.size() - 1);
            holder.ivCircle.setSelected(position == list.size() - 1);
            holder.viewDown.setSelected(position == list.size() -1);
            return convertView;
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class ViewHolder {
            @Bind(R.id.view_up)
            View viewUp;
            @Bind(R.id.iv_circle)
            ImageView ivCircle;
            @Bind(R.id.view_down)
            View viewDown;
            @Bind(R.id.tv_people)
            TextView tvPeople;
            @Bind(R.id.tv_time)
            TextView tvTime;
            @Bind(R.id.tv_message)
            TextView tvMessage;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
