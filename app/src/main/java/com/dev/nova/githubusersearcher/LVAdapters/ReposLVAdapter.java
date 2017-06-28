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

import static com.dev.nova.githubusersearcher.Buffer.repo;

public class ReposLVAdapter extends BaseAdapter {

    Context context;
    ArrayList<ReposListItem> reposList;

    public ReposLVAdapter(Context c){

        context = c;

        reposList = new ArrayList<ReposListItem>();

        for (int i = 0; i<repo.getItems().size(); i++){

            reposList.add(new ReposListItem(repo.getAvatar(i), repo.getLogin(i), repo.getName(i), repo.getDescription(i), repo.getForks(i)));
        }

    }

    @Override
    public int getCount() {
        return reposList.size();
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

        view = inflater.inflate(R.layout.repo_item, viewGroup, false);

        ImageView owner_image = (ImageView) view.findViewById(R.id.owner_image);
        TextView owner_login = (TextView) view.findViewById(R.id.owner_login);
        TextView repo_name = (TextView) view.findViewById(R.id.repo_name);
        TextView repo_description = (TextView) view.findViewById(R.id.repo_description);
        TextView repo_forks = (TextView) view.findViewById(R.id.repo_forks);

        ReposListItem reposItem = reposList.get(i);

        Picasso.with(context)
                .load(reposItem.avatar)
                .into(owner_image);
        owner_login.setText(reposItem.login);
        repo_name.setText(reposItem.name);
        repo_description.setText(reposItem.description);
        repo_forks.setText(reposItem.forks);

        return view;
    }
}

class ReposListItem{
    String avatar;
    String login;
    String name;
    String description;
    String forks;

    ReposListItem(String avatar, String login, String name, String description, String forks){
        this.avatar = avatar;
        this.login = login;
        this.name = name;
        this.description = description;
        this.forks = forks;
    }
}

