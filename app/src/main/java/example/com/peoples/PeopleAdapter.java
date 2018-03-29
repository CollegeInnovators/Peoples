package example.com.peoples;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by derri on 07/03/2018.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterViewHolder> {

    static PlayerDetails[] details;
    PeopleAdapter(PlayerDetails[] details){
        this.details = details;

    }

    public static class PeopleAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView fName, lName, position;
        ImageView small_dp;
        Context mContext;


        public PeopleAdapterViewHolder(final View itemView) {
            super(itemView);
           mContext = itemView.getContext();
           fName =  itemView.findViewById(R.id.tv_first_recyclerLayout);
           lName = itemView.findViewById(R.id.tv_last_recyclerLayout);
           position = itemView.findViewById(R.id.tv_position_recyclerLayout);
           small_dp = itemView.findViewById(R.id.profile_image);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(itemView.getContext(), ProfilesActivity.class);
                   intent.putExtra("obj",details)
                           .putExtra("pos", getAdapterPosition());
                   itemView.getContext().startActivity(intent);

               }
           });
        }
    }

    @NonNull
    @Override
    public PeopleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_layout, parent,false);
        return new PeopleAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapterViewHolder holder, int position) {

        holder.fName.setText(details[position].firstName);
        holder.lName.setText(details[position].lastName);
        holder.position.setText(details[position].position);
        int resID = holder.mContext.getResources().getIdentifier(details[position].imageName , "mipmap", holder.mContext.getPackageName());
        holder.small_dp.setImageBitmap(BitmapFactory.decodeResource(holder.mContext.getResources(), resID));
    }

    @Override
    public int getItemCount() {
        return details.length;
    }



}
