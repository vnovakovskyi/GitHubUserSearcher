package com.dev.nova.githubusersearcher.LVAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.nova.githubusersearcher.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.dev.nova.githubusersearcher.Buffer.user;

public class UsersLVAdapter extends BaseAdapter{

    Context context;
    ArrayList<UsersListItem> usersList;

    public UsersLVAdapter(Context c){

        context = c;

        usersList = new ArrayList<UsersListItem>();

        for (int i = 0; i<user.getItems().size(); i++){

            usersList.add(new UsersListItem(user.getAvatar_url(i), user.getLogin(i), user.getScore(i)));
        }

    }

    @Override
    public int getCount() {
        return usersList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;

        view = inflater.inflate(R.layout.user_item, viewGroup, false);

        ImageView user_avatar = (ImageView) view.findViewById(R.id.user_image);
        TextView user_login = (TextView) view.findViewById(R.id.user_login);
        TextView user_score = (TextView) view.findViewById(R.id.user_score);

        UsersListItem usersItem = usersList.get(i);

        Picasso.with(context)
                .load(usersItem.avatar)
                .into(user_avatar);
        user_login.setText(usersItem.login);
        user_score.setText(usersItem.score);

        return view;
    }
}

class UsersListItem{
    String avatar;
    String login;
    String score;

    UsersListItem(String avatar, String login, String score){
        this.avatar = avatar;
        this.login = login;
        this.score = score;
    }
}
