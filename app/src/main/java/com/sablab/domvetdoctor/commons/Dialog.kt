package com.sablab.domvetdoctor.commons

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.util.getString
import kotlinx.android.synthetic.main.alert_dialog.view.*
import kotlinx.android.synthetic.main.alert_dialog.view.btn_cancle
import kotlinx.android.synthetic.main.alert_dialog.view.tv_message
import kotlinx.android.synthetic.main.alert_dialog.view.tv_title
import kotlinx.android.synthetic.main.single_chose_list_row.view.*
import kotlinx.android.synthetic.main.trade_long_action_dialog.view.*

object Dialog {
    fun alert() = AlertDialogBuilder()

    fun dialog() = AlertDialogBuilder()

    fun systemDialog() =
        SystemAlertDialogBuilder()

    fun singleChooseDialog() =
        SigleChooseDialogBuilder()

    fun longActionDailog() =
        LongActionDialogBuilder()

    fun bottomSheetDialog() =
        BottomSheetDialogBuilder()

    class AlertDialogBuilder {
        private var title: Any? = null
        private var message: Any? = null
        private var isCancelable = true

        private var positiveText: Any = R.string.accept
        private var positiveAction: (() -> Unit)? = null

        private var negativeText: Any = R.string.cancel
        private var negativeAction: (() -> Unit)? = null

        private var onDismissAction: (() -> Unit)? = null

        fun message(message: Any): AlertDialogBuilder {
            this.message = message
            return this
        }

        fun title(title: Any): AlertDialogBuilder {
            this.title = title
            return this
        }

        fun dismissAction(action: () -> Unit): AlertDialogBuilder {
            this.onDismissAction = action
            return this
        }

        fun cancelable(isCancelable: Boolean): AlertDialogBuilder {
            this.isCancelable = isCancelable
            return this
        }

        fun positive(text: Any? = null, action: () -> Unit): AlertDialogBuilder {
            if (text != null)
                positiveText = text
            positiveAction = action
            return this
        }

        fun negative(text: Any? = null, action: () -> Unit): AlertDialogBuilder {
            if (text != null)
                negativeText = text
            negativeAction = action
            return this
        }

        fun show(activity: Activity?) {
            activity ?: throw Exception("activity is null object return")
            val alertBuilder = AlertDialog.Builder(activity)
            var alert: AlertDialog? = null
            alertBuilder.setCancelable(isCancelable)
            val vs: View =
                LayoutInflater.from(activity).inflate(R.layout.alert_dialog, null, false)

            if (title != null) {
                vs.tv_title.text = title!!.getString(activity)
                vs.tv_title.visibility = View.VISIBLE
            } else {
                vs.tv_title.visibility = View.GONE
            }

            if (message != null) {
                vs.tv_message.text = message!!.getString(activity)
                vs.tv_message.visibility = View.VISIBLE
            } else {
                vs.tv_message.visibility = View.GONE
            }
            if (positiveAction != null) {
                vs.btn_accept.text = positiveText.getString(activity)
                vs.btn_accept.setOnClickListener {
                    positiveAction?.invoke()
                    alert?.dismiss()
                }
                vs.btn_accept.visibility = View.VISIBLE
            } else {
                vs.btn_accept.visibility = View.GONE
            }

            if (negativeAction != null) {
                vs.btn_cancle.text = negativeText.getString(activity)
                vs.btn_cancle.setOnClickListener {
                    negativeAction?.invoke()
                    alert?.dismiss()
                }
                vs.btn_cancle.visibility = View.VISIBLE
            } else {
                vs.btn_cancle.visibility = View.GONE
            }

            alertBuilder.setTitle(null)

            alertBuilder.setOnDismissListener {
                onDismissAction?.invoke()
            }

            alertBuilder.setView(vs)
            try {
                alert = alertBuilder.show()
                alert.window?.setBackgroundDrawableResource(android.R.color.transparent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    class SystemAlertDialogBuilder {
        private var title: Any? = null
        private var message: Any? = null
        private var isCancelable = true

        private var positiveText: Any = R.string.accept
        private var positiveAction: (() -> Unit)? = null

        private var negativeText: Any = R.string.cancel
        private var negativeAction: (() -> Unit)? = null

        fun message(message: Any): SystemAlertDialogBuilder {
            this.message = message
            return this
        }

        fun title(title: Any): SystemAlertDialogBuilder {
            this.title = title
            return this
        }

        fun cancelable(isCancelable: Boolean): SystemAlertDialogBuilder {
            this.isCancelable = isCancelable
            return this
        }

        fun positive(text: Any? = null, action: () -> Unit): SystemAlertDialogBuilder {
            if (text != null)
                positiveText = text
            positiveAction = action
            return this
        }

        fun negative(text: Any? = null, action: () -> Unit): SystemAlertDialogBuilder {
            if (text != null)
                negativeText = text
            negativeAction = action
            return this
        }

        fun show(activity: Activity?) {
            activity ?: throw Exception("activity is null object return")
            val alertBuilder = AlertDialog.Builder(activity)
            var alert: AlertDialog? = null
            alertBuilder.setCancelable(isCancelable)

            if (title != null) {
                alertBuilder.setTitle(title!!.getString(activity))
            } else {
                alertBuilder.setTitle(null)
            }

            if (message != null) {
                alertBuilder.setMessage(message!!.getString(activity))
            } else {
                alertBuilder.setMessage("")
            }


            alertBuilder.setPositiveButton(positiveText.getString(activity)) { dialofInterface, _ ->
                positiveAction?.invoke()
                dialofInterface.dismiss()
            }

            alertBuilder.setNegativeButton(negativeText.getString(activity)) { dialofInterface, _ ->
                negativeAction?.invoke()
                dialofInterface.dismiss()
            }

            alertBuilder.setTitle(null)

            try {
                alert = alertBuilder.show()
                alert.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setTextColor(ContextCompat.getColor(activity, R.color.colorAccent))
                alert.getButton(AlertDialog.BUTTON_NEGATIVE)
                    .setTextColor(ContextCompat.getColor(activity, R.color.colorAccent))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    class LongActionDialogBuilder {
        private var title: Any? = null
        private var message: Any? = null
        private var isCancelable = true

        private var longActionText: Any = R.string.accept
        private var longActionAction: (() -> Unit)? = null

        private var negativeText: Any = R.string.cancel
        private var negativeAction: (() -> Unit)? = null

        fun setMessage(message: Any): LongActionDialogBuilder {
            this.message = message
            return this
        }

        fun setTitle(title: Any): LongActionDialogBuilder {
            this.title = title
            return this
        }

        fun setCancelable(isCancelable: Boolean): LongActionDialogBuilder {
            this.isCancelable = isCancelable
            return this
        }

        fun longAction(text: Any? = null, action: () -> Unit) {
            if (text != null)
                longActionText = text
            longActionAction = action
        }

        fun negative(text: Any? = null, action: () -> Unit) {
            if (text != null)
                negativeText = text
            negativeAction = action
        }

        fun show(activity: Activity?) {
            activity ?: throw Exception("activity is null object return")
            val alertBuilder = AlertDialog.Builder(activity)
            var alert: AlertDialog? = null
            alertBuilder.setCancelable(isCancelable)
            val vs: View =
                LayoutInflater.from(activity)
                    .inflate(R.layout.trade_long_action_dialog, null, false)

            if (title != null) {
                vs.tv_title.text = title!!.getString(activity)
                vs.tv_title.visibility = View.VISIBLE
            } else {
                vs.tv_title.visibility = View.GONE
            }

            if (message != null) {
                vs.tv_message.text = message!!.getString(activity)
                vs.tv_message.visibility = View.VISIBLE
            } else {
                vs.tv_message.visibility = View.GONE
            }

            vs.btn_long_action.text = longActionText.getString(activity)
            vs.btn_long_action.setOnClickListener {
                longActionAction?.invoke()
                alert?.dismiss()
            }

            vs.btn_cancle.text = negativeText.getString(activity)
            vs.btn_cancle.setOnClickListener {
                negativeAction?.invoke()
                alert?.dismiss()
            }
            alertBuilder.setTitle(null)
            try {
                alert = alertBuilder.show()
                alert.window?.setBackgroundDrawableResource(android.R.color.transparent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    class SigleChooseDialogBuilder {
        private var title: Any? = null
        private var isCancelable = true
        private var data: ArrayList<SingleChoseOption> = arrayListOf()
        private var adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>? = null


        fun setTitle(title: Any): SigleChooseDialogBuilder {
            this.title = title
            return this
        }

        fun setCancelable(isCancelable: Boolean): SigleChooseDialogBuilder {
            this.isCancelable = isCancelable
            return this
        }

        fun option(
            title: Any,
            @DrawableRes avatar: Int = 0,
            isChecked: Boolean = false,
            selectAction: () -> Unit
        ): SigleChooseDialogBuilder {
            data.add(
                SingleChoseOption(
                    title = title,
                    avatar = avatar,
                    clickAction = selectAction,
                    isChecked = isChecked
                )
            )
            return this
        }

        fun <T> option(
            values: Array<T>,
            command: SingleChoseDialogFacade<T>
        ): SigleChooseDialogBuilder {
            for (value in values) {
                data.add(
                    SingleChoseOption(
                        title = command.getName(value),
                        avatar = command.getAvatar(value),
                        isChecked = command.getIsChecked(value),
                        clickAction = { command.apply(value) }
                    )
                )
            }
            return this
        }


        fun <T> adapter(adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>): SigleChooseDialogBuilder {
            this.adapter = adapter
            return this
        }

        fun show(activity: Activity?) {
            activity ?: throw Exception("activity is null object return")
            val alertBuilder = AlertDialog.Builder(activity)
            alertBuilder.setCancelable(isCancelable)
            val vs: View =
                LayoutInflater.from(activity).inflate(R.layout.single_chose_dialog, null, false)

            if (title != null) {
                vs.findViewById<TextView>(R.id.tv_title).text = title!!.getString(activity)
                vs.findViewById<TextView>(R.id.tv_title).visibility = View.VISIBLE
                vs.findViewById<View>(R.id.spliterator).visibility = View.VISIBLE
            } else {
                vs.findViewById<TextView>(R.id.tv_title).visibility = View.GONE
                vs.findViewById<View>(R.id.spliterator).visibility = View.GONE
            }

            if (!checkOptionListIsOneSelected(
                    data
                )
            )
                throw  Exception("option list checked element no one. more than one. Place set one item is chechked")

            if (this.adapter == null) {
                val adapter =
                    SingleChoseAdapter()
                adapter.submitList(data)
                vs.findViewById<RecyclerView>(R.id.rv_single_chose).adapter = adapter
            } else {
                vs.findViewById<RecyclerView>(R.id.rv_single_chose).adapter = this.adapter
            }
            alertBuilder.setTitle(null)

            alertBuilder.setView(vs)

            try {
                val dialog = alertBuilder.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    class BottomSheetDialogBuilder {

        private var title: Any? = null
        private var isCancelable = true
        private var data: ArrayList<BottomSheetDialogOption> = arrayListOf()
        private var adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>? = null

        fun setTitle(title: Any): BottomSheetDialogBuilder {
            this.title = title
            return this
        }

        fun setCancelable(isCancelable: Boolean): BottomSheetDialogBuilder {
            this.isCancelable = isCancelable
            return this
        }

        fun option(
            title: Any,
            @DrawableRes avatar: Int = 0,
            @ColorRes textColor: Int = 0,
            selectAction: () -> Unit
        ): BottomSheetDialogBuilder {
            data.add(
                BottomSheetDialogOption(
                    title = title,
                    avatar = avatar,
                    clickAction = selectAction,
                    textColor = textColor
                )
            )
            return this
        }

        fun <T> option(
            values: Array<T>,
            command: BottomSheetDialogDialogFacade<T>
        ): BottomSheetDialogBuilder {
            for (value in values) {
                data.add(
                    BottomSheetDialogOption(
                        title = command.getName(value),
                        avatar = command.getAvatar(value),
                        clickAction = { command.apply(value) },
                        textColor = command.getTextColot(value)
                    )
                )
            }
            return this
        }


        fun <T> adapter(adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>): BottomSheetDialogBuilder {
            this.adapter = adapter
            return this
        }

        fun show(activity: Activity?) {
            activity ?: throw Exception("activity is null object return")
            val alertBuilder = BottomSheetDialog(activity, R.style.BottomSheetDialogTheme)
            alertBuilder.setCancelable(isCancelable)
            val vs: View =
                LayoutInflater.from(activity).inflate(R.layout.bottom_sheet_dialog, null, false)

            if (title != null) {
                vs.findViewById<TextView>(R.id.tv_title).text = title!!.getString(activity)
                vs.findViewById<TextView>(R.id.tv_title).visibility = View.VISIBLE
                vs.findViewById<View>(R.id.spliterator).visibility = View.VISIBLE
            } else {
                vs.findViewById<TextView>(R.id.tv_title).visibility = View.GONE
                vs.findViewById<View>(R.id.spliterator).visibility = View.GONE
            }
            if (this.adapter == null) {
                val adapter =
                    BotomSheetDialogAdapter {
                        alertBuilder.dismiss()
                    }
                adapter.submitList(data)
                vs.findViewById<RecyclerView>(R.id.rv_single_chose).adapter = adapter
            } else {
                vs.findViewById<RecyclerView>(R.id.rv_single_chose).adapter = this.adapter
            }
            alertBuilder.setTitle(null)

            alertBuilder.setContentView(vs)

            try {
                alertBuilder.window?.setBackgroundDrawableResource(android.R.color.transparent)
                alertBuilder.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    private fun checkOptionListIsOneSelected(data: java.util.ArrayList<SingleChoseOption>): Boolean {
        var isCheckedCount = 0
        for (datum in data) {
            if (datum.isChecked) {
                isCheckedCount += 1
            }
        }
        return 0 == isCheckedCount || 1 == isCheckedCount
    }

    class SingleChoseOption(
        @DrawableRes val avatar: Int,
        val title: Any,
        val isChecked: Boolean,
        val clickAction: (() -> Unit)? = null
    ) {
        companion object {
            val DIFF_UTILL = object : DiffUtil.ItemCallback<SingleChoseOption>() {
                override fun areItemsTheSame(
                    oldItem: SingleChoseOption,
                    newItem: SingleChoseOption
                ) = oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: SingleChoseOption,
                    newItem: SingleChoseOption
                ) = oldItem.avatar == newItem.avatar

            }
        }
    }


    class BottomSheetDialogOption(
        @DrawableRes val avatar: Int,
        @ColorRes val textColor: Int,
        val title: Any,
        val clickAction: (() -> Unit)? = null
    ) {
        companion object {
            val DIFF_UTILL = object : DiffUtil.ItemCallback<BottomSheetDialogOption>() {
                override fun areItemsTheSame(
                    oldItem: BottomSheetDialogOption,
                    newItem: BottomSheetDialogOption
                ) = oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: BottomSheetDialogOption,
                    newItem: BottomSheetDialogOption
                ) = oldItem.avatar == newItem.avatar

            }
        }
    }


    class SingleChoseAdapter :
        ListAdapter<SingleChoseOption, SingleChoseViewHolder>(
            SingleChoseOption.DIFF_UTILL
        ) {
        var inflater: LayoutInflater? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleChoseViewHolder {
            if (inflater == null) {
                inflater = LayoutInflater.from(parent.context)
            }
            return SingleChoseViewHolder(
                inflater!!.inflate(R.layout.single_chose_list_row, parent, false)
            )
        }

        override fun onBindViewHolder(holder: SingleChoseViewHolder, position: Int) {
            holder.onBind(getItem(position))
        }

    }

    class BotomSheetDialogAdapter(private val itemSelectAction: (() -> Unit)? = null) :
        ListAdapter<BottomSheetDialogOption, BottomSheetDialogViewHolder>(
            BottomSheetDialogOption.DIFF_UTILL
        ) {
        var inflater: LayoutInflater? = null

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BottomSheetDialogViewHolder {
            if (inflater == null) {
                inflater = LayoutInflater.from(parent.context)
            }
            return BottomSheetDialogViewHolder(
                view = inflater!!.inflate(R.layout.bottom_sheet_dialog_list_row, parent, false),
                itemSelectAction = itemSelectAction
            )
        }

        override fun onBindViewHolder(holder: BottomSheetDialogViewHolder, position: Int) {
            holder.onBind(getItem(position))
        }

    }


    class SingleChoseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var item: SingleChoseOption? = null
        fun onBind(obj: SingleChoseOption) {
            item = obj

            if (item?.avatar != 0) {
                item?.avatar?.let { itemView.iv_avatar.setImageResource(it) }
                itemView.iv_avatar.visibility = View.VISIBLE
            } else {
                itemView.iv_avatar.visibility = View.GONE
            }

            itemView.tv_title.text = item?.title?.getString(itemView.context)
            itemView.rb_checked.isChecked = item?.isChecked ?: false
            itemView.rb_checked.setOnCheckedChangeListener { buttonView, isChecked ->
                item?.clickAction?.invoke()
            }
            itemView.setOnClickListener {
                item?.clickAction?.invoke()
            }
        }

    }

    class BottomSheetDialogViewHolder(
        view: View,
        private val itemSelectAction: (() -> Unit)? = null
    ) :
        RecyclerView.ViewHolder(view) {
        var item: BottomSheetDialogOption? = null
        fun onBind(obj: BottomSheetDialogOption) {
            item = obj

            if (item?.avatar != 0) {
                item?.avatar?.let { itemView.iv_avatar.setImageResource(it) }
                itemView.iv_avatar.visibility = View.VISIBLE
            } else {
                itemView.iv_avatar.visibility = View.GONE
            }

            itemView.tv_title.text = item?.title?.getString(itemView.context)
            if (item != null && item!!.textColor > 0) {
                itemView.tv_title.setTextColor(
                    ContextCompat.getColor(itemView.context, item!!.textColor)
                )
            }
            itemView.setOnClickListener {
                item?.clickAction?.invoke()
                itemSelectAction?.invoke()
            }
        }

    }
}

interface SingleChoseDialogFacade<T> {

    fun getName(item: T): CharSequence

    fun getAvatar(item: T): Int

    fun getIsChecked(item: T): Boolean

    fun apply(item: T)

}


interface BottomSheetDialogDialogFacade<T> {

    fun getName(item: T): CharSequence

    fun getAvatar(item: T): Int

    fun getTextColot(item: T): Int

    fun apply(item: T)

}
