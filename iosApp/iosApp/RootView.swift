import SwiftUI
import Shared

struct RootView: View {
    let root: RootComponent

    @State private var showContent = false
    
    var body: some View {
        StackView(
            stackValue: StateValue(root.childStack),
            getTitle: {
                switch($0) {
                case is RootComponentChild.HomeChild: return "Home"
                case is RootComponentChild.LoginChild: return "L"
                default: return ""
                }
            },
            onBack: root.onBackClicked,
            childContent: {
                switch ($0) {
                case let child as RootComponentChild.HomeChild: HomeView(component: child.component)
                case let child as RootComponentChild.LoginChild: LoginView(component: child.component)
                default: EmptyView()
                }
            }
        )
    }
}
