package com.example.votecasting;

import android.content.Context;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.OutputStream;
import java.util.List;

public class ImageAdapter2 extends RecyclerView.Adapter<ImageAdapter2.ImageViewHolder> {
    private Context mContext;
    private List<Uploads> mUploads;
    private OnItemClickListener mListener;

    public ImageAdapter2(Context context, List<Uploads> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Uploads uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getImgName());
        Picasso.with(mContext)
                .load(uploadCurrent.getImgUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.img_description);
            imageView = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);


        }
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {

                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem download = menu.add(Menu.NONE, 1, 1, "Download");

            download.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {

                    switch (item.getItemId()) {

                        case 1:
                            mListener.onDownloadClick(position);
                            return true;
                    }
                }
            }
            return false;
        }


    }
    public interface OnItemClickListener {

        void onDownloadClick(int position);
    }

    public void setOnItemClickListener(ImageAdapter2.OnItemClickListener listener) {
        mListener = listener;
    }

}