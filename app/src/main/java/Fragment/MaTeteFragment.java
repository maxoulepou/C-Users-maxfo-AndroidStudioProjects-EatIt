package Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.eatit.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Model.BD_Ressenti;

/**
 * Gère le fragement "Ma Tête" contenu dans le fragment Ressenti Fragment.
 */
public class MaTeteFragment extends Fragment {

    private BD_Ressenti bdr;
    private String liste_emotion="";
    private ToggleButton heureux, calme, serein, fier, reconnaissant, pensif, confiant, anxieux, triste, deprime, perdu, mefiant, coupable, surpris, enerve, apeure, embarasse, autre;
    private EditText commentaires;
    private Button enregistrer;
    private String date_selectionne;


    public MaTeteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bdr = new BD_Ressenti(getContext());

        View view = inflater.inflate(R.layout.fragment_ma_tete, container, false);

        date_selectionne = getActivity().getIntent().getStringExtra("date_choisie");

        if (date_selectionne == null) {
            Calendar cldr = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            date_selectionne = dateFormat.format(cldr.getTime());

        }

        commentaires = (EditText) view.findViewById(R.id.commentaires);

        enregistrer = (Button) view.findViewById(R.id.bouton_enregistrer_tete);

        heureux = (ToggleButton) view.findViewById(R.id.bouton_heureux);
        calme = (ToggleButton) view.findViewById(R.id.bouton_calme);
        serein = (ToggleButton) view.findViewById(R.id.bouton_serein);
        fier = (ToggleButton) view.findViewById(R.id.bouton_fier);
        reconnaissant = (ToggleButton) view.findViewById(R.id.bouton_reconnaissant);
        pensif = (ToggleButton) view.findViewById(R.id.bouton_pensif);
        confiant = (ToggleButton) view.findViewById(R.id.bouton_confiant);
        anxieux = (ToggleButton) view.findViewById(R.id.bouton_anxieux);
        triste = (ToggleButton) view.findViewById(R.id.bouton_triste);
        deprime = (ToggleButton) view.findViewById(R.id.bouton_deprime);
        perdu = (ToggleButton) view.findViewById(R.id.bouton_perdu);
        mefiant = (ToggleButton) view.findViewById(R.id.bouton_mefiant);
        coupable = (ToggleButton) view.findViewById(R.id.bouton_coupable);
        surpris = (ToggleButton) view.findViewById(R.id.bouton_surpris);
        enerve = (ToggleButton) view.findViewById(R.id.bouton_enerve);
        apeure = (ToggleButton) view.findViewById(R.id.bouton_apeure);
        embarasse = (ToggleButton) view.findViewById(R.id.bouton_embarasse);
        autre = (ToggleButton) view.findViewById(R.id.bouton_autree);


        heureux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (heureux.isChecked()) {
                    liste_emotion += "Heureux(se) ";
                    heureux.setBackgroundDrawable(getResources().getDrawable(R.drawable.heureux));
                }
                else {
                    heureux.setBackgroundDrawable(getResources().getDrawable(R.drawable.heureuxbis));
                }
            }
        }
        );

        calme.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (calme.isChecked()) {
                                               liste_emotion += "Calme ";
                                               calme.setBackgroundDrawable(getResources().getDrawable(R.drawable.calme));
                                           }
                                           else {
                                               calme.setBackgroundDrawable(getResources().getDrawable(R.drawable.calmebis));
                                           }
                                       }
                                   }
        );

        serein.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (serein.isChecked()) {
                                               liste_emotion += "Serein(e) ";
                                               serein.setBackgroundDrawable(getResources().getDrawable(R.drawable.serein));
                                           }
                                           else {
                                               serein.setBackgroundDrawable(getResources().getDrawable(R.drawable.sereinbis));
                                           }
                                       }
                                   }
        );

        fier.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (fier.isChecked()) {
                                              liste_emotion += "Fier(e) ";
                                              fier.setBackgroundDrawable(getResources().getDrawable(R.drawable.fier));
                                          }
                                          else {
                                              fier.setBackgroundDrawable(getResources().getDrawable(R.drawable.fierbis));
                                          }
                                      }
                                  }
        );

        reconnaissant.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (reconnaissant.isChecked()) {
                                              liste_emotion += "Reconnaissant(e) ";
                                              reconnaissant.setBackgroundDrawable(getResources().getDrawable(R.drawable.reconnaissant));
                                          }
                                          else {
                                              reconnaissant.setBackgroundDrawable(getResources().getDrawable(R.drawable.reconnaissantbis));
                                          }
                                      }
                                  }
        );

        pensif.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 if (pensif.isChecked()) {
                                                     liste_emotion += "Pensif(ve) ";
                                                     pensif.setBackgroundDrawable(getResources().getDrawable(R.drawable.pensif));
                                                 }
                                                 else {
                                                     pensif.setBackgroundDrawable(getResources().getDrawable(R.drawable.pensifbis));
                                                 }
                                             }
                                         }
        );

        confiant.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 if (confiant.isChecked()) {
                                                     liste_emotion += "Confiant(e) ";
                                                     confiant.setBackgroundDrawable(getResources().getDrawable(R.drawable.confiant));
                                                 }
                                                 else {
                                                     confiant.setBackgroundDrawable(getResources().getDrawable(R.drawable.confiantbis));
                                                 }
                                             }
                                         }
        );

        anxieux.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (anxieux.isChecked()) {
                                                liste_emotion += "Anxieux(se) ";
                                                anxieux.setBackgroundDrawable(getResources().getDrawable(R.drawable.anxieux));
                                            }
                                            else {
                                                anxieux.setBackgroundDrawable(getResources().getDrawable(R.drawable.anxieuxbis));
                                            }
                                        }
                                    }
        );

        triste.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (triste.isChecked()) {
                                                liste_emotion += "Triste(e) ";
                                                triste.setBackgroundDrawable(getResources().getDrawable(R.drawable.triste));
                                            }
                                            else {
                                                triste.setBackgroundDrawable(getResources().getDrawable(R.drawable.tristebis));
                                            }
                                        }
                                    }
        );

        deprime.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (deprime.isChecked()) {
                                              liste_emotion += "Déprimé(e) ";
                                              deprime.setBackgroundDrawable(getResources().getDrawable(R.drawable.deprime));
                                          }
                                          else {
                                              deprime.setBackgroundDrawable(getResources().getDrawable(R.drawable.deprimebis));
                                          }
                                      }
                                  }
        );

        perdu.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (perdu.isChecked()) {
                                              liste_emotion += "Perdu(e) ";
                                              perdu.setBackgroundDrawable(getResources().getDrawable(R.drawable.perdu));
                                          }
                                          else {
                                              perdu.setBackgroundDrawable(getResources().getDrawable(R.drawable.perdubis));
                                          }
                                      }
                                  }
        );

        mefiant.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         if (mefiant.isChecked()) {
                                             liste_emotion += "Méfiant(e) ";
                                             mefiant.setBackgroundDrawable(getResources().getDrawable(R.drawable.mefiant));
                                         }
                                         else {
                                             mefiant.setBackgroundDrawable(getResources().getDrawable(R.drawable.mefiantbis));
                                         }
                                     }
                                 }
        );

        coupable.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         if (coupable.isChecked()) {
                                             liste_emotion += "Coupable(e) ";
                                             coupable.setBackgroundDrawable(getResources().getDrawable(R.drawable.coupable));
                                         }
                                         else {
                                             coupable.setBackgroundDrawable(getResources().getDrawable(R.drawable.coupablebis));
                                         }
                                     }
                                 }
        );

        surpris.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         if (surpris.isChecked()) {
                                             liste_emotion += "Surpris(e) ";
                                             surpris.setBackgroundDrawable(getResources().getDrawable(R.drawable.surpris));
                                         }
                                         else {
                                             surpris.setBackgroundDrawable(getResources().getDrawable(R.drawable.surprisbis));
                                         }
                                     }
                                 }
        );

        enerve.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (enerve.isChecked()) {
                                               liste_emotion += "Énervé(e) ";
                                               enerve.setBackgroundDrawable(getResources().getDrawable(R.drawable.enerve));
                                           }
                                           else {
                                               enerve.setBackgroundDrawable(getResources().getDrawable(R.drawable.enervebis));
                                           }
                                       }
                                   }
        );

        apeure.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (apeure.isChecked()) {
                                               liste_emotion += "Apeuré(e) ";
                                               apeure.setBackgroundDrawable(getResources().getDrawable(R.drawable.apeure));
                                           }
                                           else {
                                               apeure.setBackgroundDrawable(getResources().getDrawable(R.drawable.apeurebis));
                                           }
                                       }
                                   }
        );

        embarasse.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (embarasse.isChecked()) {
                                               liste_emotion += "Embarassé(e) ";
                                               embarasse.setBackgroundDrawable(getResources().getDrawable(R.drawable.embarasse));
                                           }
                                           else {
                                               embarasse.setBackgroundDrawable(getResources().getDrawable(R.drawable.embarassebis));
                                           }
                                       }
                                   }
        );

        autre.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             if (autre.isChecked()) {
                                                 liste_emotion += "Autre ";
                                                 autre.setBackgroundDrawable(getResources().getDrawable(R.drawable.autree));
                                             }
                                             else {
                                                 autre.setBackgroundDrawable(getResources().getDrawable(R.drawable.autreebis));
                                             }
                                         }
                                     }
        );

        ajouterRessentiTete();

        return view;
    }


    /**
     * Permet d'ajouter un ressenti dans la base de donnée en fonction des informations entrées par l'utilisateur.
     */
    public void ajouterRessentiTete() {
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentaire = commentaires.getText().toString();

                boolean isInserted = bdr.insererRessentiTete(date_selectionne, liste_emotion, commentaire);


                if (isInserted == true) {
                    Toast.makeText(getActivity(), "Vos données ont été ajoutées", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Vos données n'ont pas été ajoutées", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
