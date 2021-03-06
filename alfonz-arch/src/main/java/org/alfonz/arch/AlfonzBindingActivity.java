package org.alfonz.arch;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;


public abstract class AlfonzBindingActivity<T extends AlfonzViewModel, B extends ViewDataBinding> extends AlfonzActivity implements AlfonzView
{
	private T mViewModel;
	private B mBinding;


	public abstract T setupViewModel();
	public abstract B inflateBindingLayout(@NonNull LayoutInflater inflater);


	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mViewModel = setupViewModel();
		mBinding = setupBinding(getLayoutInflater());
		setContentView(mBinding.getRoot());
	}


	public T getViewModel()
	{
		return mViewModel;
	}


	public B getBinding()
	{
		return mBinding;
	}


	private B setupBinding(@NonNull LayoutInflater inflater)
	{
		B binding = inflateBindingLayout(inflater);
		binding.setVariable(BR.view, this);
		binding.setVariable(BR.viewModel, getViewModel());
		return binding;
	}
}
