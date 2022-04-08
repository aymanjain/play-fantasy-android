package com.mw.eleven11.UI.createTeam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mw.eleven11.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamPlayerFootballAdapter extends RecyclerView.Adapter<TeamPlayerFootballAdapter.MyviewHolder> {

    private final CreateFootballTeamFragment mCreateTeamFragment;
    int layoutId = 0;

    public TeamPlayerFootballAdapter(int layoutId, CreateFootballTeamFragment createTeamFragment) {
        this.layoutId = layoutId;
        this.mCreateTeamFragment = createTeamFragment;

    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new TeamPlayerFootballAdapter.MyviewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        if (mCreateTeamFragment.getTotalSelectedPlayers()==0) {
            holder.imageView.setImageResource(R.drawable.ic_team_user);
        }else if (mCreateTeamFragment.getTotalSelectedPlayers()>position){
            holder.imageView.setImageResource(R.drawable.team_selected_green);
        }else {
            holder.imageView.setImageResource(R.drawable.ic_team_user);
        }
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.user_img)
        ImageView imageView;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
