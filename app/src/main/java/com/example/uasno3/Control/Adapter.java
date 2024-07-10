package com.example.uasno3.Control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uasno3.Model.Mahasiswa;
import com.example.uasno3.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Mahasiswa> mahasiswaList;
    private Context context;

    public Adapter(Context context, List<Mahasiswa> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa mahasiswa = mahasiswaList.get(position);
        holder.textViewNo.setText("No               : " + mahasiswa.getNo());
        holder.textViewNama.setText("Nama            : " + mahasiswa.getNama());
        holder.textViewNim.setText("NIM               : " + mahasiswa.getNim());
        holder.textViewIpk.setText("IPK                : " + mahasiswa.getIpk());
        holder.textViewMatkul.setText("Mata Kuliah: " + mahasiswa.getMatkul());
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNama, textViewNim, textViewIpk, textViewMatkul, textViewNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNo = itemView.findViewById(R.id.textViewNo);
            textViewNama = itemView.findViewById(R.id.textViewNama);
            textViewNim = itemView.findViewById(R.id.textViewNim);
            textViewIpk = itemView.findViewById(R.id.textViewIpk);
            textViewMatkul = itemView.findViewById(R.id.textViewMatkul);
        }
    }
}
