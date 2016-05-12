package termine24.secondinterviewtest.app.activities.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import termine24.secondinterviewtest.R;
import termine24.secondinterviewtest.app.model.Contact;
import termine24.secondinterviewtest.app.model.Contacts;

/**
 * Created by shanemurphy on 14/01/2016.
 * Copyright (c) 2016 Shore. All rights reserved.
 */
public class ContactAdapter extends BaseAdapter {

    private Contacts data;

    public ContactAdapter() {
        this.data = new Contacts();
    }

    public int getCount() {
       return this.data.size();
    }

    public Contact getItem(int pos) {
        return this.data.get(pos);
    }

    class ViewHolder {

        final TextView nameTextView;
        final TextView phoneTextView;
        final TextView emailTextView;

        public ViewHolder(View v) {
            nameTextView = (TextView) v.findViewById(R.id.listitem_contact_name);
            phoneTextView = (TextView) v.findViewById(R.id.listitem_contact_phone);
            emailTextView = (TextView) v.findViewById(R.id.listitem_contact_email);
        }
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_contact, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Contact contact = getItem(position);
        holder.nameTextView.setText(contact.getName());
        holder.phoneTextView.setText(contact.getMobile());
        holder.emailTextView.setText(contact.getEmail());
        return convertView;
    }


    public void setContacts(List<Contact> contacts) {
        this.data.clear();
        if (contacts != null && !contacts.isEmpty()) {
            this.data.addAll(contacts);
        }
        notifyDataSetChanged();
    }
}
