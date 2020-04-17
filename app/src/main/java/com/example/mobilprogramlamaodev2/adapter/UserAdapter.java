package com.example.mobilprogramlamaodev2.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilprogramlamaodev2.R;
import com.example.mobilprogramlamaodev2.models.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    ArrayList<User> userList;
    LayoutInflater inflater;

    public UserAdapter(Context context, ArrayList<User> users) {
        inflater = LayoutInflater.from(context);
        this.userList = users;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User selectedProduct = userList.get(position);
        holder.setData(selectedProduct, position);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView userName, password;
        ImageView productImage, deleteproduct;
        ToggleButton sw_show_password;

        int position;


        public MyViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.userName);
            password = (TextView) itemView.findViewById(R.id.password);
            productImage = (ImageView) itemView.findViewById(R.id.productImage);
            sw_show_password = itemView.findViewById(R.id.sw_show_password);

            sw_show_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        password.setText(userList.get(position).getPassword());
                    }
                    else{
                        password.setText("********");
                    }


                }
            });

        }

        public void setData(User user, int position) {

            this.userName.setText(user.getUserName());
//            this.password.setText(user.getPassword());
            this.password.setText("********");
            this.productImage.setImageResource(user.getImageId());
            this.position=position;


        }

        @Override
        public void onClick(View v) {


        }


    }
}