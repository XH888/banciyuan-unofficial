package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.model.PersonAskBeanModel;
import com.xh.study.bcy.bean.AskBean;
import com.xh.study.bcy.utils.FormatUtil;

import de.hdodenhof.circleimageview.CircleImageView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class AskUserViewBinder extends ItemViewBinder<PersonAskBeanModel,AskUserViewBinder.AskUserViewHolder>{

    Context mContext ;
    public AskUserViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected AskUserViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new AskUserViewHolder(inflater.inflate(R.layout.ask_user_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull AskUserViewHolder holder, @NonNull PersonAskBeanModel item) {
        AskBean askBean = item.getAskBeans().get(0);
        holder.ask_item_time_tv.setText(FormatUtil.longToString( askBean.getAtime()*1000,"MM-dd" ));
        if("1".equals( askBean.getAnonymous() )){
            holder.ask_answer_head_img.setImageResource(R.drawable.user_pic_anonymous);
        }else if(askBean.getCavatar()!=null){
           Glide.with(mContext).load(askBean.getCavatar()).into( holder.ask_answer_head_img);
        }
        holder. ask_item_question_tv.setText(askBean.getContent());
        holder. ask_item_answer_tv.setText(askBean.getAnswer().getContent());
        holder. read_more.setText(mContext.getString(R.string.look_for_more_gouda,String.valueOf( item.getAskBeans().size()-1)));
    }

    class AskUserViewHolder extends RecyclerView.ViewHolder {
        TextView ask_item_time_tv;
        CircleImageView ask_answer_head_img;
        TextView ask_item_question_tv,ask_item_answer_tv;
        TextView read_more;
        AskUserViewHolder(View itemView) {
            super(itemView);
            ask_item_time_tv = itemView.findViewById(R.id.ask_item_time_tv);
            ask_answer_head_img = itemView.findViewById(R.id.ask_answer_head_img);
            ask_item_question_tv = itemView.findViewById(R.id.ask_item_question_tv);
            ask_item_answer_tv = itemView.findViewById(R.id.ask_item_answer_tv);
            read_more = itemView.findViewById(R.id.read_more);


        }
    }
}
