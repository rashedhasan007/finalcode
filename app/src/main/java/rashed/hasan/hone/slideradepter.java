package rashed.hasan.hone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class slideradepter extends RecyclerView.Adapter<slideradepter.sliderViewholder> {
    private List<slideritem> slideritems;
    private Context context;
    private ViewPager2 viewPager2;
    public slideradepter(List<slideritem>slideritems,ViewPager2 viewPager2)
    {
        this.slideritems=slideritems;
        this.viewPager2=viewPager2;
    }
    @NonNull
    @Override
    public sliderViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new sliderViewholder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slider_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull sliderViewholder holder, int position) {
        holder.setImage(slideritems.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setting on click listener
                // for our items of recycler items.
            }
        });

    }

    @Override
    public int getItemCount() {
        return slideritems.size();
    }

    class sliderViewholder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        sliderViewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageslide);
        }
        void setImage(slideritem slideritem)
        {
            imageView.setImageResource(slideritem.getImage());
        }
    }
}
