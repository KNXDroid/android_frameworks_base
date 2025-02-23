/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.systemui.bouncer.ui

import android.app.AlertDialog
import android.content.Context
import com.android.systemui.dagger.SysUISingleton
import com.android.systemui.dagger.qualifiers.Application
import com.android.systemui.statusbar.phone.SystemUIDialog
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface BouncerViewModule {
    /** Binds BouncerView to BouncerViewImpl and makes it injectable. */
    @Binds fun bindBouncerView(bouncerViewImpl: BouncerViewImpl): BouncerView

    companion object {

        @Provides
        @SysUISingleton
        fun bouncerDialogFactory(@Application context: Context): BouncerDialogFactory {
            return object : BouncerDialogFactory {
                override fun invoke(): AlertDialog {
                    return SystemUIDialog(context)
                }
            }
        }
    }
}
