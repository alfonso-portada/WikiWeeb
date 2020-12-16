package com.acasema.wikiweeb.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.data.model.Article;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;
import java.util.Random;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    List<Article> list;
    OnArticleLisener lisener;
    String[] ArticleType;

    //interfaz para interactuar con los elementos del recicleview
    public interface OnArticleLisener{
        void onClickArticle(Article article);
    }

    /**
     * @param list lista del adapter
     * @param lisener donde ocurira los metodos para interactuar con los elementos del recicleview
     */
    public ArticleAdapter(List<Article> list, OnArticleLisener lisener) {
        this.list = list;
        this.lisener = lisener;
    }


    //region elementos override obligatorios por la interfaz RecyclerView.Adapter<T>
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_generico, parent, false);
        ArticleType = parent.getResources().getStringArray(R.array.ArticleType);
        return new ViewHolder(view, lisener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.letterIcon.setLetter(list.get(position).getTitle());

        Random rnd = new Random(list.get(position).hashCode());
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.letterIcon.setShapeColor(color);


        holder.tvHeading.setText(ArticleType[list.get(position).getType()]+ " de "+ list.get(position).getTitle());
        holder.tvLongText.setText(list.get(position).getLongText());
        holder.tvSubTitle.setText("cantidad "+ list.get(position).getSubTitle());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //endregion

    public void update(List<Article> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    /**
     * elementos del recicle review
     */
    class ViewHolder extends RecyclerView.ViewHolder{

        MaterialLetterIcon letterIcon;//esto se subtituira por una imagen

        TextView tvHeading;
        TextView tvLongText;
        TextView tvSubTitle;


        public ViewHolder(@NonNull View itemView, final OnArticleLisener listener) {
            super(itemView);

            letterIcon = itemView.findViewById(R.id.letterIcon);

            tvHeading = itemView.findViewById(R.id.tvHeading);
            tvLongText = itemView.findViewById(R.id.tvLongText);
            tvSubTitle = itemView.findViewById(R.id.tvSubtitulo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickArticle(list.get(getAdapterPosition()));
                }
            });
        }
    }
}
