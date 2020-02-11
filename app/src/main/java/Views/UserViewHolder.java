package Views;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GithubUserViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.fragment_contact_recycler_view) TextView mTextView;

    public GithubUserViewHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    // Methode a modifier plus tard pour l'affichage des informations des pro
    /**
    public void ipdateWithGithubUser(GithubUser githubUser){
        this.mTextView.setText(githubUser.getLogin());
    } **/
}
