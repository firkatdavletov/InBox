//
//  TestView.swift
//  iosApp
//
//  Created by Фиркат Давлетов on 22.09.2024.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct LoginView: View {
    let component: LoginComponent
    @State private var showContent = false
    
    var body: some View {
        VStack {
            Button("Click me!") {
                withAnimation {
                    showContent = !showContent
                }
            }

            if showContent {
                VStack(spacing: 16) {
                    Image(systemName: "swift")
                        .font(.system(size: 200))
                        .foregroundColor(.accentColor)
                    Text("SwiftUI: \(Greeting().greet())")
                    Button("Go to Home") {
                        component.onLoginClicked()
                    }
                }
                .transition(.move(edge: .top).combined(with: .opacity))
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
    
}
